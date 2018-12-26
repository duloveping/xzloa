(function ($) {
    $.fn.downCount = function (options, callback) {
        var settings = $.extend({
            date: null,
            offset: null
        }, options);
        if (!settings.date) {
            $.error('Date is not defined.');
        }
        if (!Date.parse(settings.date)) {
            $.error('Incorrect date format, it should look like this, 12/24/2012 12:00:00.');
        }
        var container = this;
        function countdown() {
            var difference = new Date(settings.date).getTime() - new Date().getTime();
            if (difference < 0) {
                clearInterval(interval);
                if (callback && typeof callback === 'function')
                    callback();
                return;
            }
            var _second = 1000,
                _minute = _second * 60,
                _hour = _minute * 60,
                _day = _hour * 24;
            var days = Math.floor(difference / _day),
                hours = Math.floor((difference % _day) / _hour),
                minutes = Math.floor((difference % _hour) / _minute),
                seconds = Math.floor((difference % _minute) / _second);
            days = (String(days).length >= 2) ? days : '0' + days;
            hours = (String(hours).length >= 2) ? hours : '0' + hours;
            minutes = (String(minutes).length >= 2) ? minutes : '0' + minutes;
            seconds = (String(seconds).length >= 2) ? seconds : '0' + seconds;
            container.find('.days').text(days);
            container.find('.hours').text(hours);
            container.find('.minutes').text(minutes);
            container.find('.seconds').text(seconds);
            container.find('.days_ref').text("天");
            container.find('.hours_ref').text("时");
            container.find('.minutes_ref').text("分");
            container.find('.seconds_ref').text("秒");
        };
        var interval = setInterval(countdown, 1000);
    };
})(jQuery);
