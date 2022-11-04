<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>구해줘 홈즈! 김우진 최현호</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${root }/assets/img/favicon.png" rel="icon">
  <link href="${root }/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${root }/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${root }/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${root }/assets/css/style.css" rel="stylesheet">

  <!-- Custom CSS File -->
  <link href="${root }/assets/css/user.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Siimple - v4.7.0
  * Template URL: https://bootstrapmade.com/free-bootstrap-landing-page/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header">
    <div class="container-fluid">

      <div class="logo">
        <h1><a href="index.html">홈즈</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <button type="button" class="nav-toggle"><i class="bx bx-menu"></i></button>
      <nav class="nav-menu">
        <ul id="menu-item">
          <li class="active"><a href="#header" class="scrollto">Home</a></li>
          <!-- <li><a href="#about" class="scrollto">About Us</a></li> -->
          <li><a href="#notice" class="scrollto">Notice</a></li>
          
          <c:if test="${!empty user }">
          	<li class="drop-down" id="user-info"><a href="">User</a>
	            <ul>
	              <li><a href="#" data-bs-toggle="modal" data-bs-target="#infoModal">Info</a></li>
	              <li><a href="#" id="logout-btn">Logout</a></li>
	              <!-- <li class="drop-down"><a href="#">Logout</a>
	                <ul>
	                  <li><a href="#">Deep Drop Down 1</a></li>
	                  <li><a href="#">Deep Drop Down 2</a></li>
	                  <li><a href="#">Deep Drop Down 3</a></li>
	                  <li><a href="#">Deep Drop Down 4</a></li>
	                  <li><a href="#">Deep Drop Down 5</a></li>
	                </ul>
	              </li> -->
	              <li><a href="#" id="withdrawal-btn">Withdrawal</a></li>
	              <li><a href="#" id="noticeAdd-btn" data-bs-toggle="modal" data-bs-target="#noticeModal" >add notice</a></li>
	              <!-- <li><a href="#">Drop Down 5</a></li> -->
	            </ul>
	        </li>
          </c:if>
          
          <!-- <li><a href="#contact" class="scrollto">Contact Us</a></li> -->
          <c:if test="${empty user }">
          	<li id="login-li"><a id="login-btn" class="scrollto" type="button" data-bs-toggle="modal" data-bs-target="#loginModal">Login</a></li>
          	<li id="join-li"><a id="join-btn" class="scrollto" type="button" data-bs-toggle="modal" data-bs-target="#joinModal">Join</a></li>
          </c:if>
        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End #header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div class="hero-container">
      <h1>구해줘 홈즈!</h1>
      <h2>김우진 최현호</h2>

      <!-- <form action="forms/notify.php" method="post" role="form" class="php-email-form"> -->
        <div class="row no-gutters">
          <!-- <div class="col-md-6 form-group pr-md-1">
            <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required>
          </div>
          <div class="col-md-6 form-group pl-md-1">
            <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required>
          </div> -->
          <div>
          	
          	
          </div>
          
   		  <div class="row no-gutters" id="searchByRegion">
   		  	<button class="search-type" id="searchByAPTNameBtn" onclick="toggleSearchBox();" style="size:100px;">아파트 이름 검색</button>
   		  	<div class = "col-md-3">
	            <select class = "form-group pr-md-1 form-select" name="sido" id="sido"></select>
	          </div>
	          <div class = "col-md-3">
	            <select class = "col-md-4 form-group pr-md-1 form-select" name="gugun" id="gugun">
	              <option value="">구군선택</option>
	            </select>
	          </div>
	          <div class = "col-md-3">
	            <select class = "col-md-4 form-group pr-md-1 form-select" name="dong" id="dong">
	              <option value="">동선택</option>
	            </select>
	          </div>
	          <div class="row col-md-3 text-center">
	            <c:if test="${empty user }">
	            	<button  id="goSearchByAddr" type="button" class="btn btn-secondary">검색</button>
	            </c:if>
	            <c:if test="${!empty user }">
	            	<button  id="goSearchByAddr" type="button" class="btn btn-secondary col-md-4">검색</button>
	            	<button  id="registInterestRegion" type="button" class="btn btn-secondary col-md-7">즐겨찾기</button>
	            </c:if>
	          </div>
            
   		  </div>
   		  
   		  <div class="row no-gutters hide" id="searchByAPTName">
   		  	<button class="search-type" id="searchByRegionBtn" onclick="toggleSearchBox();">지역 검색</button>
   		  	
   		  	<div class = "col-md-8">
	            <input class="form-control" id="searchAPTName" type="text">
	          </div>
	          <div class="col-md-4 text-center row">
	            <button id="goSearchByAPTName" type="button" class="btn btn-secondary col-md-12">검색</button>
	          </div>
   		  </div>

        </div>

	<div class="row no-gutters" id="interestRegionDiv">
		<c:if test="${!empty user }">
			<c:forEach items="${user.interestRegion }" var="region">
				<button class="col-md-3 regionBtn" onclick="searchInterestRegion('${region.sidoName }', '${region.gugunName }', '${region.dongName }');">${region.dongName }</button>
			</c:forEach>
		</c:if>
	</div>
        
      <!-- </form> -->
    </div>
  </section><!-- #hero -->

  <main id="main">

    <!-- ======= About Section ======= -->
    <!-- <section id="about" class="about">
      <div class="container">

        <div class="row">
          <div class="col-lg-6">
            <img src="assets/img/about-img.jpg" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6 pt-4 pt-lg-0">
            <h3>Voluptatem dignissimos provident quasi corporis voluptates sit assumenda.</h3>
            <p class="fst-italic">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
              magna aliqua.
            </p>
            <ul>
              <li><i class="bx bx-check-double"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat.</li>
              <li><i class="bx bx-check-double"></i> Duis aute irure dolor in reprehenderit in voluptate velit.</li>
              <li><i class="bx bx-check-double"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate trideta storacalaperda mastiro dolore eu fugiat nulla pariatur.</li>
            </ul>
            <p>
              Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
              velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
              culpa qui officia deserunt mollit anim id est laborum
            </p>
          </div>
        </div>

      </div>
    </section> -->
    <!-- End About Section -->

    <!-- ======= Why Us Section ======= -->
    <section>
      <div class="container">
        <div id = "aptListSection" class="row" style = "display: none;">
          <div id = "tableWrap" class="col-lg-6">
            <table class="table table-hover text-center">
              <tr>
                <th>아파트이름</th>
                <th id="buildYear">건축년도</th>
                <th id="area">면적</th>
                <th>법정동</th>
                <th  id="dealAmount">거래금액</th>
              </tr>
              <tbody id="aptlist"></tbody>
            </table>
          </div>
          <div id="mapWrap" class="col-lg-6">
            <div id="map"  style="width:500px;height:500px;">
            </div>
          </div>
        </div>
      </div>
          
      
    </section>
    <!-- <section id="why-us" class="why-us section-bg">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="card">
              <img src="assets/img/why-us-1.jpg" class="card-img-top" alt="...">
              <div class="card-icon">
                <i class="bx bx-book-reader"></i>
              </div>
              <div class="card-body">
                <h5 class="card-title"><a href="">Our Mission</a></h5>
                <p class="card-text">Lorem ipsum dolor sit amet, consectetur elit, sed do eiusmod tempor ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="card">
              <img src="assets/img/why-us-2.jpg" class="card-img-top" alt="...">
              <div class="card-icon">
                <i class="bx bx-calendar-edit"></i>
              </div>
              <div class="card-body">
                <h5 class="card-title"><a href="">Our Plan</a></h5>
                <p class="card-text">Sed ut perspiciatis unde omnis iste natus error sit voluptatem doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. </p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="card">
              <img src="assets/img/why-us-3.jpg" class="card-img-top" alt="...">
              <div class="card-icon">
                <i class="bx bx-landscape"></i>
              </div>
              <div class="card-body">
                <h5 class="card-title"><a href="">Our Vision</a></h5>
                <p class="card-text">Nemo enim ipsam voluptatem quia voluptas sit aut odit aut fugit, sed quia magni dolores eos qui ratione voluptatem sequi nesciunt Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet. </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section> -->
    <!-- End Why Us Section -->

    <!-- ======= Frequenty Asked Questions Section ======= -->
    <section class="faq" id="notice">
      <div class="container">

        <div class="section-title">
          <h2>공지사항</h2>
        </div>

        <ul class="faq-list">

          <!-- <li>
            <a data-bs-toggle="collapse" class="collapsed" data-bs-target="#faq1">Non consectetur a erat nam at lectus urna duis? <i class="bx bx-down-arrow-alt icon-show"></i><i class="bx bx-x icon-close"></i></a>
            <div id="faq1" class="collapse" data-bs-parent=".faq-list">
              <p>
                Feugiat pretium nibh ipsum consequat. Tempus iaculis urna id volutpat lacus laoreet non curabitur gravida. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non.
              </p>
            </div>
          </li>

          <li>
            <a data-bs-toggle="collapse" data-bs-target="#faq2" class="collapsed">Feugiat scelerisque varius morbi enim nunc faucibus a pellentesque? <i class="bx bx-down-arrow-alt icon-show"></i><i class="bx bx-x icon-close"></i></a>
            <div id="faq2" class="collapse" data-bs-parent=".faq-list">
              <p>
                Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi. Id interdum velit laoreet id donec ultrices. Fringilla phasellus faucibus scelerisque eleifend donec pretium. Est pellentesque elit ullamcorper dignissim. Mauris ultrices eros in cursus turpis massa tincidunt dui.
              </p>
            </div>
          </li>

          <li>
            <a data-bs-toggle="collapse" data-bs-target="#faq3" class="collapsed">Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi? <i class="bx bx-down-arrow-alt icon-show"></i><i class="bx bx-x icon-close"></i></a>
            <div id="faq3" class="collapse" data-bs-parent=".faq-list">
              <p>
                Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Faucibus pulvinar elementum integer enim. Sem nulla pharetra diam sit amet nisl suscipit. Rutrum tellus pellentesque eu tincidunt. Lectus urna duis convallis convallis tellus. Urna molestie at elementum eu facilisis sed odio morbi quis
              </p>
            </div>
          </li>

          <li>
            <a data-bs-toggle="collapse" data-bs-target="#faq4" class="collapsed">Ac odio tempor orci dapibus. Aliquam eleifend mi in nulla? <i class="bx bx-down-arrow-alt icon-show"></i><i class="bx bx-x icon-close"></i></a>
            <div id="faq4" class="collapse" data-bs-parent=".faq-list">
              <p>
                Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi. Id interdum velit laoreet id donec ultrices. Fringilla phasellus faucibus scelerisque eleifend donec pretium. Est pellentesque elit ullamcorper dignissim. Mauris ultrices eros in cursus turpis massa tincidunt dui.
              </p>
            </div>
          </li>

          <li>
            <a data-bs-toggle="collapse" data-bs-target="#faq5" class="collapsed">Tempus quam pellentesque nec nam aliquam sem et tortor consequat? <i class="bx bx-down-arrow-alt icon-show"></i><i class="bx bx-x icon-close"></i></a>
            <div id="faq5" class="collapse" data-bs-parent=".faq-list">
              <p>
                Molestie a iaculis at erat pellentesque adipiscing commodo. Dignissim suspendisse in est ante in. Nunc vel risus commodo viverra maecenas accumsan. Sit amet nisl suscipit adipiscing bibendum est. Purus gravida quis blandit turpis cursus in
              </p>
            </div>
          </li> -->

          <li>
            <a data-bs-toggle="collapse" data-bs-target="#faq6" class="collapsed">공지사항 표시용입니다. <i class="bx bx-down-arrow-alt icon-show"></i><i class="bx bx-x icon-close"></i></a>
            <div id="faq6" class="collapse" data-bs-parent=".faq-list">
              <div class = "noticeContent">
                <p>
                  안녕하세요 SSAFY8기 김우진 최현호 입니다.
                </p>
                <c:forEach items="${user.interestRegion }" var="dong">
                	<p> ${dong.dongCode } ${dong.sidoName } ${dong.gugunName } ${dong.dongName }</p>
                </c:forEach>
              </div>
              <div class = "noticeEdit">
                <button  type="button" class="noticeEditBtn btn btn-secondary" data-bs-toggle="modal" data-bs-target="#noticeModal">수정</button>
                <button  type="button" class="noticeDelBtn btn btn-warning"> 삭제</button>
            </div>
            </div>
          </li>

        </ul>

      </div>
    </section><!-- End Frequenty Asked Questions Section -->

    <!-- ======= Contact Us Section ======= -->
    <!-- <section id="contact" class="contact section-bg">
      <div class="container">

        <div class="section-title">
          <h2>Contact Us</h2>
        </div>

        <div class="row justify-content-center">

          <div class="col-lg-3 col-md-5 mb-5 mb-md-0">
            <div class="info">
              <div class="address">
                <i class="bx bx-map"></i>
                <p>A108 Adam Street<br>New York, NY 535022</p>
              </div>

              <div class="email">
                <i class="bx bx-envelope"></i>
                <p>info@example.com</p>
              </div>

              <div class="phone">
                <i class="bx bx-phone-call"></i>
                <p>+1 5589 55488 55s</p>
              </div>
            </div>

            <div class="social-links">
              <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
              <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
              <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
              <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
            </div>

          </div>

          <div class="col-lg-5 col-md-7">
            <form action="forms/contact.php" method="post" role="form" class="php-email-form">
              <div class="form-group">
                <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required>
              </div>
              <div class="form-group mt-3">
                <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required>
              </div>
              <div class="form-group mt-3">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required>
              </div>
              <div class="form-group mt-3">
                <textarea class="form-control" name="message" rows="5" placeholder="Message" required></textarea>
              </div>
              <div class="my-3">
                <div class="loading">Loading</div>
                <div class="error-message"></div>
                <div class="sent-message">Your message has been sent. Thank you!</div>
              </div>
              <div class="text-center"><button type="submit">Send Message</button></div>
            </form>
          </div>

        </div>

      </div>
    </section> -->
    <!-- End Contact Us Section -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="container">
      <div class="copyright">
        &copy;  <strong><span>SSAFY</span></strong>. 구해줘 홈즈! 김우진 최현호 <small>prod by 김종성 서준배</small>
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/free-bootstrap-landing-page/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End #footer -->

  <!-- ======= Login Modal ======= -->
  <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="loginModalLabel">Welcome</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form action="/user.do/login" method="post" id="login-form">
          	<input type="hidden" name="action" value="login">
          	<!-- <input type="email" class="form-control" name="email" id="login-email" placeholder="Email" required>  -->
          	<div class="input-group">
                <input
                  type="text"
                  class="form-control"
                  id="emailid"
                  name="emailid"
                  placeholder="이메일아이디"
                />
                <span class="input-group-text">@</span>
                <select
                  class="form-select"
                  id="emaildomain"
                  name="emaildomain"
                  aria-label="이메일 도메인 선택"
                >
                  <option selected>선택</option>
                  <option value="ssafy.com">싸피</option>
                  <option value="google.com">구글</option>
                  <option value="naver.com">네이버</option>
                  <option value="kakao.com">카카오</option>
                </select>
              </div>
          	<input type="password" class="form-control" name="password" id="login-password" placeholder="Password" required>	
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary" id="modal-login-btn" >Login</button>
        </div>
      </div>
    </div>
  </div>

  <!-- ======= Join Modal ======= -->
  <div class="modal fade" id="joinModal" tabindex="-1" aria-labelledby="joinModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="joinModalLabel">Welcome</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form action="/user.do/join" method="post" id="join-form">
          	<input type="hidden" name="action" value="join">
          	<div class="input-group">
                <input
                  type="text"
                  class="form-control"
                  id="join-emailid"
                  name="emailid"
                  placeholder="이메일아이디"
                />
                <span class="input-group-text">@</span>
                <select
                  class="form-select"
                  id="join-emaildomain"
                  name="emaildomain"
                  aria-label="이메일 도메인 선택"
                >
                  <option selected>선택</option>
                  <option value="ssafy.com">싸피</option>
                  <option value="google.com">구글</option>
                  <option value="naver.com">네이버</option>
                  <option value="kakao.com">카카오</option>
                </select>
              </div>
	        <input type="password" class="form-control" name="password" id="join-password" placeholder="Password" required>
	        <input type="text" class="form-control" name="name" id="join-username" placeholder="Username" required>
	        <input type="text" class="form-control" name="addr" id="join-address" placeholder="Address" required>
	        <input type="tel" pattern="010-[0-9]{4}-[0-9]{4}" class="form-control" name="phone" id="join-phone" placeholder="Phone" required>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary" id="modal-join-btn">Join</button>
        </div>
      </div>
    </div>
  </div>

  <c:if test="${!empty user }">
  	  <!-- ======= Info Modal ======= -->
	  <div class="modal fade" id="infoModal" tabindex="-1" aria-labelledby="infoModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	      <div class="modal-content">
	        <div class="modal-header">
	          <h5 class="modal-title" id="infoModalLabel">Info</h5>
	          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	        </div>
	        <div class="modal-body">
	          <form action="${root }/user.do/update" method="post" id="modify-form">
	          	<input type="hidden" name="action" value="modify">
	          	<div class="input-group">
                <input
                  type="text"
                  class="form-control"
                  id="info-emailid"
                  name="emailid"
                  value="${user.email.id }"
                  placeholder="이메일아이디"
                />
                <span class="input-group-text">@</span>
                <select
                  class="form-select"
                  id="info-emaildomain"
                  name="emaildomain"
                  aria-label="이메일 도메인 선택"
                >
                  <option selected>선택</option>
                  <option value="ssafy.com">싸피</option>
                  <option value="google.com">구글</option>
                  <option value="naver.com">네이버</option>
                  <option value="kakao.com">카카오</option>
                </select>
              </div>
		        <input type="password" class="form-control" name="password" id="info-password" placeholder="Password" required>
		        <input type="text" class="form-control" name="name" id="info-username" placeholder="Username" value="${user.name }" required>
		        <input type="text" class="form-control" name="addr" id="info-address" placeholder="Address" value="${user.addr }" required>
		        <input type="tel" pattern="010-[0-9]{4}-[0-9]{4}" class="form-control" name="phone" id="info-phone" value="${user.phone }" placeholder="Phone" required>
	          </form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	          <button type="button" class="btn btn-primary" id="modal-update-btn">Update</button>
	        </div>
	      </div>
	    </div>
	  </div>
  </c:if>

  <!-- ======= Notice Modal ======= -->
  <div class="modal fade" id="noticeModal" tabindex="-1" aria-labelledby="noticeModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="noticeModalLabel">Notice</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <input type="text" class="form-control" name="noticeTitle" id="notice-title" placeholder="title" required>
          <textarea type="textbox" class="form-control" name="noticeContent" id="notice-content" placeholder="content" required></textarea>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary" id="modal-noticeUpload-btn" >Update</button>
        </div>
      </div>
    </div>
  </div>
  
  <script>
  	function toggleSearchBox() {
  		document.querySelector("#searchByRegion").classList.toggle("hide");
  		document.querySelector("#searchByAPTName").classList.toggle("hide");
  	}
  	
  	window.onload = function() {  		
  		let domainSel = document.querySelector("#info-emaildomain");
  		for (let option of domainSel.options) {
  		    if(option.value === "${user.email.domain}") {
  		        option.selected = true;
  		    }
  		}
  	}
  	
  	<c:if test="${!empty loginResult}">
  		alert("${loginResult}");
  	</c:if>
  	
  	<c:if test="${!empty modifyResult}">
  		alert("${modifyResult}");
  	</c:if>
  </script>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

  <script src="assets/js/user.js"></script>

  <script src="assets/js/admin.js"></script>
  <!-- 지도 관련-->
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=32b7b36540e75a778fb8400e8a821a41&libraries=services"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="assets/js/map.js"></script>

</body>

</html>