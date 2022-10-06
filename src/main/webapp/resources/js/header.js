$(function(){
    
    header();

    function header(){

        let nav = $(".b_header_nav");
        let menu_medium = $(".b_header_nav_menu_medium");
        let menu_small = $(".b_header_nav_menu_small");
        let nav_swich = false;

        nav.hover(function(){
            nav_over();
        }, function(){
            nav_out();
        })


        function nav_over(){

            if(nav_swich == false){

                menu_medium.stop(true,true).animate({
                    "opacity" : 1
                },1000)
                nav.stop(true,false).animate({
                    "height" : 250
                },500)
                menu_small.stop(true,true).animate({
                    "opacity" : 1
                },1000)
            }

            nav_swich = true
            return false;
        }

        function nav_out(){

            if(nav_swich == true){
            menu_medium.stop(true,true).animate({
                "opacity" : 0
            },500)
            nav.stop(true,false).animate({
                "height" : 50
            },500)
            menu_small.stop(true,true).animate({
                "opacity" : 0
            },500)
            }
            
            nav_swich = false
            return false;
        }
    }
    
})