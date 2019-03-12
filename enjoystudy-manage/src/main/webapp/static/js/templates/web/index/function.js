// JScript source code
function NavBgOver(id) {
    $("#" + id).removeClass().addClass("NavItemSelected");
}
function NavBgOut(id, name) {
    $("#" + id).removeClass().addClass(name == undefined ? "NavItem" : name);
}
function FouseBgOver(id) {
    $("#" + id).css("background-color", "#ff7c24");
}
function FouseBgOut(id) {
    $("#" + id).css("background-color", "Black");
}