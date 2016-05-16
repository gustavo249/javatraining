<%--
  Created by IntelliJ IDEA.
  User: Gustavo
  Date: 21/04/2016
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="../resources/css/main.css" />"/>
    <title>.: Game Land :. &copy; Graformix</title>

    <script>
        // show the given page, hide the rest
        function show(shown, hidden1, hidden2) {
            document.getElementById(shown).style.display='block';
            document.getElementById(hidden1).style.display='none';
            document.getElementById(hidden2).style.display='none';
            return false;
        }
    </script>

</head>

<body>
<div id="megabg_container">
    <div id="bg_container">
        <div id="container">
            <div id="header">
                <!-- <img src="img/top_img.jpg" alt="" style="margin:0 auto 0 auto;"/> -->
                <span id="header_text">GameLand</span>
            </div>
            <div id="menu_sword">
                <div id="tabs" class="noprint">
                    <h3 class="noscreen">Navigation</h3>
                    <ul>
                        <li><a href="#" class="sword_menu"><span class="shadow">&nbsp;STORY&nbsp;</span><span
                                class="text" onclick="show('story', 'community', 'news')">&nbsp;STORY&nbsp;</span><span class="tab-l"></span><span
                                class="tab-r"></span></a></li>
                        <li><a href="${pageContext.request.contextPath}/registration" class="sword_menu"><span class="shadow">&nbsp;CREATE ACCOUNT&nbsp;</span><span
                                class="text">&nbsp;CREATE ACCOUNT&nbsp;</span><span class="tab-l"></span><span
                                class="tab-r"></span></a></li>
                        <li><a href="#" class="sword_menu"><span class="shadow">&nbsp;COMMUNITY&nbsp;</span><span
                                class="text" onclick="show('community',  'story', 'news')">&nbsp;COMMUNITY&nbsp;</span><span class="tab-l"></span><span
                                class="tab-r"></span></a></li>
                        <li><a href="#" class="sword_menu"><span class="shadow">&nbsp;NEWS&nbsp;</span><span
                                class="text" onclick="show('news', 'story', 'community')">&nbsp;NEWS&nbsp;</span><span class="tab-l"></span><span
                                class="tab-r"></span></a></li>
                    </ul>
                    <hr class="noscreen"/>
                </div>
            </div>
            <img src="../resources/img/menu_sword_right.jpg" alt="" style="float:right;"/>
            <div id="body">
                <div id="body-leftside">
                    <div id="scroll_top"><span id="scroll_header">MENU&nbsp;</span></div>
                    <div id="scroll_middle">
                        <a href="" class="main_menu">Your hero</a>
                        <a href="" class="main_menu">Scoreboard</a>
                        <a href="" class="main_menu">Mission</a>
                        <a href="" class="main_menu">Arena</a>
                        <div class="menu_separator">
                            <div class="separator_text">Shop</div>
                        </div>
                        <a href="" class="main_menu">Weapons</a>
                        <a href="" class="main_menu">Armors</a>
                        <a href="" class="main_menu">Potions</a>
                    </div>
                    <div id="scroll_bottom"></div>
                    <div class="center">
                        <a href="http://www.mrgustavorocks.blogspot.ro" target="_blank">
                            <img src="../resources/img/mini_sword.jpg" alt="Visit Graformix Website"/>
                        </a>
                    </div>
                </div>


                <div id="body-rightside">

                    <!--The four main pages which are to be displayed in the right block-->
                    <div id="story" style="">
                        <h1>Welcome to <b style="background-color: darkred">SPARTACUS!</b></h1>
                        <p class="justify">
                            Blood and battle! In a world in which the best warriors step out of the catacombs and out
                            into the sun to decide their destiny.<br/>
                            Honour and victory await you in the dust of the arena, but also the glorious stories of an
                            ancient world. Raise your sword...
                        </p>
                        <ul class="diamond">
                            <li class="justify">
                                In Spartacus, you play as Spartacus, and as the legend says, your goal as a true warrior
                                to fight for freedom! Break out of the gladiator arena and into the streets of Rome to
                                fight the mighty Empire!
                            </li>
                            <li class="justify">
                                Fight through eight challenging levels, against unique boss enemies, then go and destroy
                                your enemies with style in the cinematic mode.
                            </li>
                        </ul>
                        <form action="${pageContext.request.contextPath}/play" method="post">
                            username: <input name="username" type="text"/><br>
                            password: <input name="password" type="password"/><br>
                            <input type="submit" name="submit">
                        </form>
                    </div>

                    <div id="community" style="display: none">
                        Comunnity
                    </div>


                    <div id="news" style="display: none">
                        News
                    </div>


                </div>
            </div>
            <div id="footer">
                <div class="hr">
                    <hr/>
                </div>
                <div class="designedby">
                    Raoul's company<br/>
                    Designed by <a href="http://www.mrgustavorocks.blogspot.ro" target="_blank" class="graformix">Gustavo </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
