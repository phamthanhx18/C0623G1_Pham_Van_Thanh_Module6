$(".sidebar ul li").on('click', function () {
    $(".sidebar ul li.active").removeClass('active');
    $(this).addClass('active');
});

$('.open-btn').on('click', function () {
    $('.sidebar').addClass('active');

});


$('.close-btn').on('click', function () {
    $('.sidebar').removeClass('active');

})

$(".menu > ul >li").click(function (e){
    //remove active from already active
    $(this).siblings().removeClass("active")
    //add active to clicked
    $(this).toggleClass("active")
    //if has sub menu open it
    $(this).find("ul").slideToggle();
    //close other sub menu if any open
    $(this).siblings().find("ul").slideUp();
    //remove active class of sub menu items
    $(this).siblings().find("ul").find("li").removeClass("active");
});

$(".menu-btn").click(function (){
    $(".sidebar").toggleClass("active");
})
