/**
 * 图片高度预设及删除
 * @param risObj
 * @param risImg
 */
function imageSize(risObj,risImg) {
    var risObjs = risObj.split(','),
        risImg=risImg?risImg:'img';
    for (var i = 0; i < risObjs.length; i++) {
        $(risObjs[i]).each(function() {
            var scale=$(this).data('scale');
            if(scale){
                $(risImg,this).height($(risImg,this).width()*scale);
                $(risImg,this).each(function() {
                    var thisimg=$(this);
                    imageloadFun(this,function(){
                        thisimg.height('').removeAttr('height');
                    })
                });
                var $self=$(this);
                $(window).resize(function() {
                    var resImg=$self.find(risImg+'.imgloading');
                    resImg.height(resImg.width()*scale);
                });
            }
        });
    }
}

/**
 * 图片加载完成回调
 * @param risObj
 * @param fun
 */
function imageloadFun(risObj,fun) {
    $(risObj).each(function() {
        if($(this).data('lazy') || $(this).data('original')){
            var thisimg=$(this),
                loadtime=setInterval(function(){
                    if(thisimg.attr('src')==thisimg.data('original') || thisimg.attr('src')==thisimg.data('lazy')){
                        clearInterval(loadtime);
                        var img = new Image(),
                            img_url=thisimg.attr('src');
                        img.src = img_url;
                        if (img.complete) {
                            if (typeof fun === "function") fun();
                            return;
                        }
                        img.onload = function() {
                            if (typeof fun === "function") fun();
                        };
                    }
                },100)
        }else if($(this).attr('src')){
            var img = new Image(),
                img_url=$(this).attr('src');
            img.src = img_url;
            if (img.complete) {
                if (typeof fun === "function") fun();
                return;
            }
            img.onload = function() {
                if (typeof fun === "function") fun();
            };
        }
    });
}

/**
 * 分类筛选动画(可控制默认选项对应的显示数量)
 * @param itObj
 * @param itControl
 * @constructor
 */
function IsotopeNum(itObj,itControl) {
    var itFun=$(itObj).isotope(),
        intItControlAttr=$(itControl+'.active a').data('filter');
    $(itControl).on('click', 'a', function() {
        var filterValue = $(this).data('filter'),
            filterValues=filterValue=='*'?'[data-type]':'[data-type='+filterValue+']',
            num=$(this).data('num');
        if(num) filterValues=function(){return $(this).index() < num;} || filterValues;
        itFun.isotope({filter:filterValues});
        if(filterValue!=intItControlAttr){
            $(filterValues+' [data-original]').each(function() {
                if($(this).data('original')!=$(this).attr('src'))
                    $(this).lazyload({event:'sporty'}).trigger('sporty');
            });
        }
    });
    // 触发默认选项点击效果
    if($(itControl+'.active a').data('num')){
        setTimeout(function () {
            $(itControl+'.active a').trigger('click');
        },500);
    }
}

Breakpoints();

var M = document.querySelector('meta[name="generator"]').getAttribute('data-variable'), D = M.split(',');
M = new Array();
M['weburl'] = D[0];
M['lang'] = D[1];
M['classnow'] = parseInt(D[2]);
M['id'] = parseInt(D[3]);
M['module'] = parseInt(D[4]);
M['tem'] = D[0] + 'templates/' + D[5];
var deviceType = /iPad/.test(navigator.userAgent) ? 't' : /Mobile|iP(hone|od)|Android|BlackBerry|IEMobile|Silk/.test(navigator.userAgent) ? 'm' : 'd', is_ucbro = /UC/.test(navigator.userAgent);

$(document).ready(function() {
    if(M['classnow']==10001){
        // 图片懒加载
        var $index_original=$('.met-index-body [data-original]');
        if($index_original.length){
            $index_original.lazyload({
                load:function(){
                    if($(this).parents('.met-index-service').length) $('.met-index-service [class*=block] li').matchHeight();
                }
            });
        }

        // 首页首屏内动画预加载
        var $met_indexbody1_appear=$('.met-index-body:eq(0) [data-plugin=appear]');
        if($met_indexbody1_appear.length){
            $met_indexbody1_appear.scrollFun(function(val){
                val.appearDiy();
            });
        }

        // 产品列表
        if($(".met-index-product").length){
            //内滚导航条（移动端）
            Breakpoints.on('xs sm',{
                enter: function(){
                    navtabSwiper('.met-index-product .nav-tabs');
                }
            })
            var problock='.met-index-product #indexprolist',
                protab='.met-index-product .nav-tabs li';
            //图片高度预设
            imageSize(problock);
            //分类筛选动画
            IsotopeNum(problock,protab);
        }

        // 新闻列表
        // 图片高度预设
        if($('.met-index-news ul.blocks-2').length) imageSize('.met-index-news ul.blocks-2');
    }
});



var imgnews = function(ele, arrow) {
    if (arrow) {
        var prev = '<div class="prevarrow"></div>',
            next = '<div class="nextarrow"></div>',
            isShow = true;
    }
    $(ele).slick({
        fade: true,
        prevArrow: prev,
        nextArrow: next,
        dots: isShow,
        autoplay: true
    })
};

var imglist = function () {
    var l = $('#teamlist'),
        item = l.find('.item'),
        w = 100 / item.length,
        halfW = w / 2;
    hoverW = w + halfW,
    sbW = w - halfW / (item.length - 1);
    item.width(w + '%');
    Breakpoints.on('md lg', {
        enter: function () {
            item.mouseover(function (event) {
                $(this).width(hoverW + '%').siblings().width(sbW + '%');
                var intro = $(this).find('.introduce'),
                    othIntro = $(this).siblings().find('.introduce');
                intro.addClass('active');
                othIntro.removeClass('active');
            });
            item.eq(0).width(hoverW + '%').siblings().width(sbW + '%');
            item.eq(0).find('.introduce').addClass('active');
        }
    })
    Breakpoints.on('xs sm', {
        enter: function () {
            item.find('.introduce').addClass('active');
            l.slick({
                dots: true,
            })
        }
    })
};

var animation = function() {
    var hot = new TimelineMax(),
        news = new TimelineMax(),
        product = new TimelineMax(),
        team = new TimelineMax(),
        about = new TimelineMax(),
        service = new TimelineMax();
    /*公共区域动画*/
    var top=new TimelineMax();
    var header = TweenMax.to('#header', 0.6, {
        autoAlpha: 1,
        top: 0,
        backgroundColor: '#eee',
        ease: Power3.easeInOut,
    });
    var navli=TweenMax.staggerTo('.navlist li', 1, {
        autoAlpha: 1,
        x: 0,
        y: 0,
        ease: Power3.easeInOut,
    }, 0.05);
    var metnav=TweenMax.to('.met-nav', 0.6, {
        backgroundColor: '#fff',
        ease: Power3.easeInOut,
    });
    var top=new TimelineMax();
    top.add(header).add(metnav).add(navli);

    function stagger(ele, time) {
        var s=TweenMax.staggerTo($(ele), 1.2, {
            autoAlpha: 1,
            x: 0,
            y: 0,
            ease: Power3.easeInOut,
        }, time);
        return s;
    }

    function common(ele) {
        var common = new TimelineMax();
        var a = TweenMax.to($(ele).find('h2'), 1.2, {
                autoAlpha: 1,
                y: 0,
                ease: Power3.easeInOut,
            }),
            b = TweenMax.to($(ele).find('.desc'), 1.2, {
                autoAlpha: 1,
                y: 0,
                ease: Power3.easeInOut,
            });
    };

    function hotTween() {
        var ele = '#hot';
        common(ele);
        var s=stagger('.met-index-hot li', 0.2);
        var a=TweenMax.staggerTo($(ele).find('.hot-btns a'), 1.2, {
            autoAlpha: 1,
            scale: 1,
            ease: Power3.easeInOut,
        }, 0.15);
        hot.add(s).add(a);
    }

    function productTween() {
        var ele = '#product';
        common(ele);
        var c = TweenMax.staggerTo($(ele).find('.nav-tabs li'), 0.6, {
                autoAlpha: 1,
                scale: 1,
                ease: Power3.easeInOut,
            }, 0.15),
            d = TweenMax.staggerTo($(ele).find('#indexprolist .widget'), 0.6, {
                autoAlpha: 1,
                scale: 1,
                x: 0,
                ease: Power3.easeInOut,

            }, 0.1);

    }

    function newsTween() {
        var ele = '#news';
        common(ele);
        TweenMax.to($(ele).find('.left-news'), 1.2, {
            autoAlpha: 1,
            x: 0,
            ease: Power3.easeInOut,
        });
        TweenMax.to($(ele).find('.right-news'), 1.2, {
            autoAlpha: 1,
            x: 0,
            ease: Power3.easeInOut,
        });
        TweenMax.to($(ele).find('.news-bg'), 1.2, {
            autoAlpha: 1,
            y: 0,
            ease: Power3.easeInOut,
        });
    }

    function teamTween() {
        var ele = '#team';
        common(ele);
        var a=TweenMax.staggerTo($(ele).find('#teamlist .item'), 1.2, {
            autoAlpha: 1,
            x: 0,
            ease: Power3.easeInOut,
        },0.05);
    }

    function aboutTween() {
        var ele = '#about';
        common(ele);
        var a = TweenMax.to($(ele).find('.img'), 1.2, {
            autoAlpha: 1,
            x: 0,
            ease: Power3.easeInOut,
        });
        var b = TweenMax.to($(ele).find('.text'), 1.2, {
            autoAlpha: 1,
            x: 0,
            ease: Power3.easeInOut,
        });
        var c = TweenMax.to($(ele).find('.prevarrow'), 1.2, {
            autoAlpha: 1,
            left: -60,
            ease: Power3.easeInOut,
        });
        var d = TweenMax.to($(ele).find('.nextarrow'), 1.2, {
            autoAlpha: 1,
            right: -60,
            ease: Power3.easeInOut,
        });
    }

    function serviceTween() {
        var ele = '#service';
        common(ele);
        var bg=$(ele).css("background-color");
        $(ele).css("background-color","#fff");
        var a=TweenMax.to($(ele), 1, {
            autoAlpha: 1,
            y:0,
            backgroundColor:bg,
            ease: Power3.easeInOut,
        });

    }
    var controller = new ScrollMagic.Controller();
    var a1 = new ScrollMagic.Scene({
        triggerElement: '#hot',
        offset:-200
    }).setTween(hotTween);
    var a2 = new ScrollMagic.Scene({
        triggerElement: '#news',
        offset:-200
    }).setTween(newsTween);
    var a3 = new ScrollMagic.Scene({
        triggerElement: '#product',
        offset:-200
    }).setTween(productTween);
    var a4 = new ScrollMagic.Scene({
        triggerElement: '#team',
        offset:-200
    }).setTween(teamTween);
    var a5 = new ScrollMagic.Scene({
        triggerElement: '#about',
        offset:-200
    }).setTween(aboutTween);
    var a6 = new ScrollMagic.Scene({
        triggerElement: '#service',
        offset:-200
    }).setTween(serviceTween);
    controller.addScene([a1, a2, a3, a4, a5, a6]);
};

$(document).ready(function() {
    imgnews('#imgnews-slick');
    imgnews('.about-list', 'arrow');
    imglist();
    animation();
    Breakpoints.on('xs sm', {
        enter: function() {
            navtabSwiper('.head-list');
        }
    })
})