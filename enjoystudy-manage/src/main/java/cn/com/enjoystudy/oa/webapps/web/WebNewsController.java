package cn.com.enjoystudy.oa.webapps.web;

import cn.com.enjoystudy.oa.bean.web.News;
import cn.com.enjoystudy.oa.bean.web.NewsSO;
import cn.com.enjoystudy.oa.service.web.NewsService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/news")
public class WebNewsController extends BaseController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("index")
    public ModelAndView index(NewsSO newsSO) {
        newsSO.setPageSize(20);
        newsSO.setShowState(true);
        newsSO.setTypeState(true);
        PageInfo<News> pageInfo = newsService.findPage(newsSO);
        ModelAndView mv = new ModelAndView("web/news/index");
        mv.getModel().put("newsSO", newsSO);
        mv.getModel().put("pageInfo", pageInfo);
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(@RequestParam("id") String id) {
        ModelAndView mv = new ModelAndView("web/news/view");
        News news = newsService.getById(id);
        mv.getModel().put("news", news);
        return mv;
    }
}
