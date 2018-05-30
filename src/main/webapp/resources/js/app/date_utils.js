function getBeginOfWeek(currentDate) {
    var date = new Date(currentDate);
    var first = date.getDate() - date.getDay() + 1;
    return new Date(date.setDate(first));
}

function getEndOfWeek(currentDate) {
    var date = new Date(currentDate);
    var first = date.getDate() - date.getDay() + 1;
    var last = first + 6;
    return new Date(date.setDate(last));
}

function getBeginOfMonth(currentDate) {
    return new Date(currentDate.getFullYear(), currentDate.getMonth(), 1);
}

function getEndOfMonth(currentDate) {
    return new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);
}

function getBeginOfYear(currentDate) {
    var result = new Date(currentDate.getTime());
    result.setMonth(0);
    result.setDate(1);
    return result;
}

function getEndOfYear(currentDate) {
    var result = new Date(currentDate.getTime());
    result.setMonth(11);
    result.setDate(31);
    return result;
}