(function ($) {
    // 创建构造函数
    function Slide(ele, options) {
        this.$ele = $(ele)//this. 构造函数的实例对象
        this.options = $.extend({
            speed: 1000,
            delay: 3000
        }, options)//拓展
        this.states = [/*每次显示的图片让中间的图片最大，两边的图片大小对称*/
            { '&zIndex': 1, width: 120, height: 150, top: 71, left: 134, $opacity: 0.5 },/*opacity为不透明级别*/
            { '&zIndex': 2, width: 130, height: 170, top: 61, left: 0, $opacity: 0.6 },
            { '&zIndex': 3, width: 170, height: 218, top: 37, left: 110, $opacity: 0.7 },
            { '&zIndex': 4, width: 224, height: 288, top: 0, left: 262, $opacity: 1 },
            { '&zIndex': 3, width: 170, height: 218, top: 37, left: 468, $opacity: 0.7 },
            { '&zIndex': 2, width: 130, height: 170, top: 61, left: 620, $opacity: 0.6 },
            { '&zIndex': 1, width: 120, height: 150, top: 71, left: 496, $opacity: 0.5 }
        ]
        this.lis = this.$ele.find('li')
        this.interval
        // 点击切换到下一张
       //$表示引用JQuery的对象
        this.$ele.find('section:nth-child(2)').on('click', function () {
            this.stop()/*find()搜索所有与指定表达式匹配的元素。这个函数是找出正在处理的元素的后代元素的好方法。*/
            this.next()
            this.play()
        }.bind(this))/*.bind(this)的效果就相当于将事件绑定的callback抽出来写，但是同时还维持了函数中的this指向*/
        // 点击切换到上一张
        this.$ele.find('section:nth-child(1)').on('click', function () {
            this.stop()
            this.prev()
            this.play()
        }.bind(this))
        this.move()
        // 让轮播图开始自动播放
        this.play()
    }
    Slide.prototype = {/*prototype将函数用作构造函数调用的时候，新创建的对象会从原型对象上继承属性和方法*/
        // 原型是一个对象，所以写成一个花括号
        // move()方法让轮播图到达states指定的状态
        // <1>当页面打开时将轮播图从中心点展开
        // <2>当轮播图已经展开时，会滚动轮播图(需要翻转states数组中的数据)
        move: function () {

            this.lis.each(function (i, el) {/*each() 方法规定为每个匹配元素规定运行的函数。

提示：返回 false 可用于及早停止循环。•i - 选择器的 index 位置
•element - 当前的元素（也可使用 "this" 选择器）*/
                $(el)
                    .css('z-index', this.states[i]['&zIndex'])/*设置CSS中元素的堆叠次序*/
                    .finish().animate(this.states[i], this.options.speed)/*animate() 方法执行 CSS属性集的自定义动画。该方法通过CSS样式将元素从一个状态改变为另一个状态。CSS属性值是逐渐改变的，
                    这样就可以创建动画效果，设置this的动画的转化速度*/
                    .find('img').css('opacity', this.states[i].$opacity)
            }.bind(this))
        },
        // 让轮播图切换到下一张
        next: function () {
            this.states.unshift(this.states.pop())/*unshift() 方法将把它的参数插入states的头部，
            并将已经存在的元素顺次地移到较高的下标处*/
            //pop删除并返回数组的最后一个元素
            this.move()
        },
        // 让轮播图滚动到上一张
        prev: function () {

            this.states.push(this.states.shift())/*push() 方法可向数组的末尾添加一个或多个元素，并返回新的长度*/
            /*shift()删除并返回数组的最后一个元素,整句话的意思就是把当前图片放到末尾*/
            this.move()
        },
        play: function () {

            this.interval = setInterval(function () {//这个this指window
                this.next()
            }.bind(this), this.options.delay)
        },
        // 停止自动播放
        stop: function () {
            clearInterval(this.interval)
        }

    }
    $.fn.zySlide = function (options) {/*$ 是 jQuery 的别名，所以
$.fn.pluginName 等同于 jQuery.prototype.pluginName
*/
        this.each(function (i, ele) {
            new Slide(ele, options)
        })/*通过高度变化（向上减小）
        来动态地隐藏所有匹配的元素，在隐藏完成后可选地触发一个回调函数，此处的回调函数为Slide*/
        return this
    }
})(jQuery)
