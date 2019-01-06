package cn.com.enjoystudy.oa.webapps.manage;

import cn.com.enjoystudy.oa.bean.base.*;
import cn.com.enjoystudy.oa.bean.register.examination.AccountRegister;
import cn.com.enjoystudy.oa.bean.sys.*;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.base.*;
import cn.com.enjoystudy.oa.service.sys.LoginLogService;
import cn.com.enjoystudy.oa.service.sys.SysMenuService;
import cn.com.enjoystudy.oa.service.sys.SysRolePositionService;
import cn.com.enjoystudy.oa.service.sys.SysRoleService;
import cn.com.enjoystudy.oa.util.IpAdressUtils;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.util.UserAgentUtils;
import cn.com.enjoystudy.oa.validation.manage.employee.EmployeeAccountValidator;
import cn.com.enjoystudy.oa.validation.manage.register.examination.AccountRegisterValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Constants;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 系统登录Controller
 * @author 广州新咨力科技有限公司-杜永生
 */
@Controller
@RequestMapping("/manage/login")
public class LoginController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private EmployeeAccountService employeeAccountService;
    @Autowired
    private EmployeeCommunicationService employeeCommunicationService;
    @Autowired
    private LoginLogService loginLogService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private BasePositionService basePositionService;
    @Autowired
    private EmployeePositionService employeePositionService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private EmployeeRoleService employeeRoleService;
    @Autowired
    private SysRolePositionService sysRolePositionService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/login/index");
        return mv;
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            if (null != object) {
                session.removeAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            }
            subject.getSession().removeAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            subject.logout();
        }
        ModelAndView mv = new ModelAndView("redirect:/manage/login/index.jhtml");
        return mv;
    }

    @ResponseBody
    @RequestMapping("login")
    public JSONObject login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("checkCode") String checkCode,
            HttpServletRequest request) {
        boolean success = false;
        String message = "登录失败";
        JSONArray array = new JSONArray();

        HttpSession session = request.getSession();
        Object object = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (null != object) {
            String code = (String) object;
            if (code.equalsIgnoreCase(checkCode)) {
                String sha1pwd = DigestUtils.sha1Hex(password);
                UsernamePasswordToken token = new UsernamePasswordToken(username, sha1pwd);
                Subject subject = SecurityUtils.getSubject();
                try {
                    subject.login(token);
                } catch (UnknownAccountException uae) {
                    logger.error("用户【" + token.getPrincipal() + "】不存在", uae);
                    message = "用户名不存在系统！";
                    success = false;
                } catch (IncorrectCredentialsException ice) {
                    logger.error("用户【 " + token.getPrincipal() + " 】的密码错误！",ice);
                    message = "密码错误！";
                    success = false;
                } catch (LockedAccountException lae) {
                    logger.error("用户【" + token.getPrincipal() + " 】的账户被锁定，请联系管理员。", lae);
                    message = "用户已经被锁定不能登录，请与管理员联系！";
                    success = false;
                } catch (DisabledAccountException dax) {
                    logger.error("用户:【" + token.getPrincipal() + "】用户已经被禁用。", dax);
                    message = "用户已经被禁用！";
                    success = false;
                } catch (ExcessiveAttemptsException eae) {
                    logger.error("用户:【" + token.getPrincipal() + "】登录次数过多！", eae);
                    message = "登录次数过多！";
                    success = false;
                } catch (ExpiredCredentialsException eca) {
                    logger.error("用户:【" + token.getPrincipal() + "】用户凭证过期！", eca);
                    message = "用户凭证过期！";
                    success = false;
                } catch (AuthenticationException ae) {
                    logger.error("用户:【" + token.getPrincipal() + "】验证失败！", ae);
                    message = "验证失败！";
                    success = false;
                } catch (Exception e) {
                    logger.error("其他异常错误！", e);
                    message = "其他异常错误！";
                    success = false;
                }

                // 验证是否成功登录的方法
                if (subject.isAuthenticated()) {
                    EmployeeAccountSO so = new EmployeeAccountSO();
                    so.setCode(username);

                    List<EmployeeAccount> list = employeeAccountService.list(so);
                    EmployeeAccount account = list.get(0);
                    subject.getSession().setAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER, account);

                    SysMenuSO menuSO = new SysMenuSO();
                    List<SysMenu> menus = null;
                    if ("admin".equals(account.getCode())) {
                        menus = sysMenuService.list(menuSO);
                    } else {
                        menuSO.setEmployeeId(account.getId());
                        menus = sysMenuService.findEmployeeMenuList(menuSO);
                    }

                    if (null != menus && menus.size() > 0) {
                        for (SysMenu menu : menus) {
                            JSONObject data = new JSONObject();
                            data.put("id", menu.getId());
                            data.put("code", menu.getCode());
                            data.put("name", menu.getName());
                            data.put("category", menu.getCategory());
                            if (StringUtils.isNotBlank(menu.getParentId())) {
                                data.put("parentId", menu.getParentId());
                            } else {
                                data.put("parentId", "0");
                            }
                            array.add(data);
                        }
                    }

                    logger.info("用户【" + username + "】成功登录！");
                    message = "成功登录！";
                    success = true;
                }
            } else {
                message = "验证码不正确！";
                success = false;
            }
        } else {
            message = "验证码已失效！";
            success = false;
        }

        DeviceType deviceType = UserAgentUtils.getDeviceType(request);
        Browser browserType = UserAgentUtils.getBrowser(request);
        Date date = new Date();

        LoginLog log = new LoginLog();
        log.setUsername(username);
        log.setRequestTime(date);
        log.setSessionid(request.getSession().getId());
        log.setIpAddress(IpAdressUtils.getIpAdrress(request));
        log.setDeviceType(deviceType.getName());
        log.setBrowserType(browserType.getName());
        log.setLoginState(success);
        log.setCaption(message);
        loginLogService.insert(log);

        JSONObject json = new JSONObject();
        json.put("message", message);
        json.put("success", success);
        json.put("menus", array);
        return json;
    }

    @RequestMapping("register")
    public ModelAndView register() {
        AccountRegister so = new AccountRegister();
        so.setIdentityType(1);

        ModelAndView mv = new ModelAndView("manage/login/register");
        mv.getModel().put("questionList", cn.com.enjoystudy.oa.common.Constants.SECURITY_QUESTION_LIST);
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("preview")
    public ModelAndView preview(AccountRegister so) {
        ModelAndView mv = new ModelAndView("manage/login/preview");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("entry")
    @ResponseBody
    public JSONObject entry(AccountRegister so, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object object = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (null != object) {
            String code = (String) object;
            if (code.equalsIgnoreCase(so.getCheckCode())) {
                AccountRegisterValidator validator = new AccountRegisterValidator();
                validator.validate(so, result);

                if (result.hasErrors()) {
                    return resultError(result.getFieldError().getDefaultMessage());
                } else {
                    String sha1pwd = DigestUtils.sha1Hex(StringUtils.trim(so.getLoginPassword()));

                    EmployeeAccount account = new EmployeeAccount();
                    account.setCategory(cn.com.enjoystudy.oa.common.Constants.ACCOUNT_CATEGORY_PERSONAL);
                    account.setLockState(true);
                    account.setCode(StringUtils.trim(so.getUsername()));
                    account.setFullName(StringUtils.trim(so.getRealname()));
                    account.setSex(so.getSex());
                    account.setLoginPassword(sha1pwd);
                    account.setIdentityType(so.getIdentityType());
                    account.setIdentityCode(StringUtils.trim(so.getIdentityCode()));
                    account.setQuestion(StringUtils.trim(so.getQuestion()));
                    account.setAnswer(StringUtils.trim(so.getAnswer()));
                    employeeAccountService.insert(account);

                    EmployeeCommunication communication = new EmployeeCommunication();
                    communication.setEmployeeId(account.getId());
                    communication.setCategory(cn.com.enjoystudy.oa.common.Constants.COMMUNICATION_CATEGORY_MYSELF);
                    communication.setMobile(StringUtils.trim(so.getMobile()));
                    communication.setEmail(StringUtils.trim(so.getEmail()));
                    employeeCommunicationService.insert(communication);

                    String str = "sys-student";
                    boolean flag = false;

                    BasePosition position = basePositionService.getByCode(str);
                    if (null == position) {
                        position = new BasePosition();
                        position.setCode(str);
                        position.setName("学员");
                        position.setShowState(true);
                        position.setCaption("系统内置职务信息，请不要删除！");
                        basePositionService.insert(position);
                        flag = true;
                    }
                    EmployeePosition ep = new EmployeePosition();
                    ep.setEmployeeId(account.getId());
                    ep.setPositionId(position.getId());
                    employeePositionService.insert(ep);

                    SysRole role = sysRoleService.getByCode(str);
                    if (null == role) {
                        role = new SysRole();
                        role.setCode(str);
                        role.setName("学员");
                        role.setCaption("系统内置角色信息，请不要删除！");
                        role.setShowState(true);
                        sysRoleService.insert(role);
                        flag = true;
                    }
                    EmployeeRole er = new EmployeeRole();
                    er.setEmployeeId(account.getId());
                    er.setRoleId(role.getId());
                    employeeRoleService.insert(er);

                    if (flag) {
                        SysRolePosition rp = new SysRolePosition();
                        rp.setPositionId(position.getId());
                        rp.setRoleId(role.getId());
                        sysRolePositionService.insert(rp);
                    }

                    return resultSuccess("注册成功");
                }
            } else {
                return resultError("验证码不正确");
            }
        } else {
            return resultError("验证码已经效");
        }


    }

    @RequestMapping("check")
    public void check(@RequestParam("username") String username, HttpServletResponse response) {
        String flag = "true";

        EmployeeAccountSO so = new EmployeeAccountSO();
        so.setCode(StringUtils.trim(username));
        if (employeeAccountService.count(so) > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }
}

