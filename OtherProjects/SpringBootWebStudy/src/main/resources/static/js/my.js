alert("我在其他文件中的js")

function getRandom(begin, end) {
    return Math.floor(Math.random() * (end - begin + 1)) + begin;
}

//返回秒数
function countDown(time) {
    var nowTime = +new Date(); //返回毫秒数，如果没有+，则返回对象。
    var inputTime = +new Date(time);
    var times = (inputTime - nowTime) / 1000;
    var d = parseInt(times / 60 / 60 / 24);
    d = d < 10 ? '0' + d : d;
    var h = parseInt(times / 60 / 60 % 24);
    h = h < 10 ? '0' + h : h;
    var m = parseInt(times / 60 % 60);
    m = m < 10 ? '0' + m : m;
    var s = parseInt(times % 60);
    s = s < 10 ? '0' + s : s;
    return d + '天' + h + '时' + m + '分' + s + '秒';
}

function SetArgument(a) {
    a = "bbb"
    return a
}

function Person(name) {
    this.name = name;
}

function SetPerson(person) {
    person.name = "被替换的名字"
    return person
}