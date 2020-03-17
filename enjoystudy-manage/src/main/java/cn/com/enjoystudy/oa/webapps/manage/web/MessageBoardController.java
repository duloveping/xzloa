package cn.com.enjoystudy.oa.webapps.manage.web;

import cn.com.enjoystudy.oa.bean.web.MessageBoard;
import cn.com.enjoystudy.oa.bean.web.MessageBoardSO;
import cn.com.enjoystudy.oa.service.web.MessageBoardService;
import cn.com.enjoystudy.oa.service.web.MessageRemarkService;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage/web/message-board")
public class MessageBoardController extends UploadController {
    @Autowired
    private MessageBoardService messageBoardService;
    @Autowired
    private MessageRemarkService messageRemarkService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/web/message-board/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(MessageBoardSO so) {
        PageInfo<MessageBoard> pageInfo = messageBoardService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }
}
