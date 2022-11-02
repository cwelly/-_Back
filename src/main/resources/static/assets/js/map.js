let url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
let regcode = "*00000000";


function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
var ctx = getContextPath();
// 전국 특별/광역시, 도
// https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000
//$.ajax({
//    url: url,
//    type: "GET",
//    data: {
//        regcode_pattern: regcode,
//    },
//    dataType: "json",
//    success: function (response) {
//        let code = ``;
//        $.each(response.regcodes, function (i, regcode) {
//            code += `
//    <option value="${regcode.code}">${regcode.name}</option>
//    `;
//        });
//        $("#sido").empty().append('<option value="">시도선택</option>').append(code);
//    },
//    error: function (xhr, status, msg) {
//        console.log("상태값 : " + status + " Http에러메시지 : " + msg);
//    },
//});
//
//$(document).on("change", "#sido", function () {
//    regcode = $(this).val().substr(0, 2) + "*00000";
//    $.ajax({
//        url: url,
//        type: "GET",
//        data: {
//            regcode_pattern: regcode,
//            is_ignore_zero: true,
//        },
//        dataType: "json",
//        success: function (response) {
//            let code = ``;
//            $.each(response.regcodes, function (i, regcode) {
//                code += `
//    <option value="${regcode.code}">${regcode.name.split(" ")[1]}</option>
//    `;
//            });
//            $("#gugun").empty().append('<option value="">구군선택</option>').append(code);
//        },
//        error: function (xhr, status, msg) {
//            console.log("상태값 : " + status + " Http에러메시지 : " + msg);
//        },
//    });
//});

//$(document).on("change", "#gugun", function () {
//    regcode = $(this).val().substr(0, 4) + "*";
//    console.log(regcode);
//    $.ajax({
//        url: url,
//        type: "GET",
//        data: {
//            regcode_pattern: regcode,
//            is_ignore_zero: true,
//        },
//        dataType: "json",
//        success: function (response) {
//            let code = ``;
//            $.each(response.regcodes, function (i, regcode) {
//                code += `
//    <option value="${regcode.code}">${regcode.name.split(" ")[2]}</option>
//    `;
//            });
//            $("#dong").empty().append('<option value="">동선택</option>').append(code);
//        },
//        error: function (xhr, status, msg) {
//            console.log("상태값 : " + status + " Http에러메시지 : " + msg);
//        },
//    });
//});

// --------------  새로 만드는  함수 처리 -------------------
//document.querySelector("#goSearch").addEventListener("click", function (){
//	console.log("눌렀을때");
//	let si = document.querySelector("#sido");
//	let si_val =si[si.selectedIndex].textContent;
//	console.log("시도 값 : "+si_val);
//	// 시도
//	let gu = document.querySelector("#gugun");
//	let gu_val =gu[gu.selectedIndex].textContent;
//	console.log("구군 값 :"+gu_val);
//	// 구군
//	let dong = document.querySelector("#dong");
//	console.log(dong.selectedIndex);
//	// 동은 기본값이 null akwsk?
//	if(dong.selectedIndex==0){
//		alert("검색 지역을 지정 해주세요");
//	}
//	else{
//		let dong_val =dong[dong.selectedIndex].textContent;
//		fetch(`/WhereIsMyHome/map.do?action=searchDong&sido=${si_val}&gugun=${gu_val}&dong=${dong_val}`)
////		fetch(`/WhereIsMyHome/map.do?action=searchName&name=태산`)
//		.then(data => data.json())
//		.then(res => console.log(res));
//	}
//
//});


// 처음 로딩시 시를 불러오는 코드
// 컨텍스트 루트 받아오기


// fetch("/WhereIsMyHome/region.do?action=sido")
fetch(ctx+"/region.do/sido")
.then(response => response.json())
    .then(data => {
        console.log(data);
	let sidoSel = document.querySelector("#sido");
	let init = document.createElement("option");
	init.textContent = "시도선택";
	
	sidoSel.appendChild(init);
	data.regions.forEach(sido => {
		let option = document.createElement("option");
		option.textContent = sido.name;
		option.value = sido.code;
		
		sidoSel.appendChild(option);
	})
});




document.querySelector("#sido").addEventListener("change", function() {
	let sidoSel = document.querySelector("#sido");
    let sidoCode = sidoSel.options[sidoSel.selectedIndex].value;
    
    console.log(ctx+`/region.do/gugun/${sidoCode}`);
    // fetch(`/WhereIsMyHome/region.do?action=gugun&sido=${sidoCode}`)
    fetch(ctx+`/region.do/gugun/${sidoCode}`)
    	.then(response => response.json())
    	.then(data => {
    		console.log(data);
    		let gugunSel = document.querySelector("#gugun");
    		
    		while (gugunSel.firstChild) {
    			gugunSel.removeChild(gugunSel.firstChild);
    		}
    		
    		let init = document.createElement("option");
    		init.textContent = "구군선택";
    		gugunSel.appendChild(init);
    		
    		data.regions.forEach(gugun => {
    			let option = document.createElement("option");
    			option.textContent = gugun.name;
    			option.value = gugun.code;
    			
    			gugunSel.appendChild(option);
    		})
    	})
});

document.querySelector("#gugun").addEventListener("change", function() {
	let gugunSel = document.querySelector("#gugun");
    let gugunCode = gugunSel.options[gugunSel.selectedIndex].value;
    //fetch(`/WhereIsMyHome/region.do?action=dong&gugun=${gugunCode}`)
    fetch(ctx+`/region.do/dong/${gugunCode}`)
    	.then(response => response.json())
    	.then(data => {
    		console.log(data.regions);
    		let dongSel = document.querySelector("#dong");
    		
    		while (dongSel.firstChild) {
    			dongSel.removeChild(dongSel.firstChild);
    		}
    		
    		let init = document.createElement("option");
    		init.textContent = "동선택";
    		dongSel.appendChild(init);
    		
    		data.regions.forEach(dong => {
    			let option = document.createElement("option");
    			option.textContent = dong.name;
    			option.value = dong.code;
    			
    			dongSel.appendChild(option);
    		})
    	});
});



///////////////////////// 아파트 매매 정보 /////////////////////////

// 동으로 검색
document.querySelector("#goSearchByAddr").addEventListener("click", function () {
    let sidoSel = document.querySelector("#sido");
    let sido = sidoSel.options[sidoSel.selectedIndex].text;

    let gugunSel = document.querySelector("#gugun");
    let gugun = gugunSel.options[gugunSel.selectedIndex].text;

    let dongSel = document.querySelector("#dong");
    let dong = dongSel.options[dongSel.selectedIndex].text;

    if(sido=="시도선택" || gugun =="구군선택" || dong=="동선택"){
    	alert("시/도 , 구/군 , 동을 정확히 설정해주세요!");
    	console.log(sido, gugun, dong);
    	return;
    }
    // let url = `/WhereIsMyHome/map.do?action=searchDong&sido=${sido}&gugun=${gugun}&dong=${dong}`;
    let url = ctx+`/map.do/searchDong/${sido}/${gugun}/${dong}`;
    console.log(url);

    fetch(`${url}`)
        .then(response => response.json())
        .then(data => {  makeList(data) });
});

// 아파트 이름으로 검색
document.querySelector("#goSearchByAPTName").addEventListener("click", function() {
    let aptName = document.querySelector("#searchAPTName").value;

    console.log(aptName);

    let url = ctx+`/map.do/searchName/${aptName}`;
    console.log(url);

    fetch(`${url}`)
        .then(response => response.json())
        .then(data => makeList(data));
});

// 관심지역 등록
document.querySelector("#registInterestRegion").addEventListener("click", function() {
	let dongSel = document.querySelector("#dong");
    let dongcode = dongSel.options[dongSel.selectedIndex].value;
    
    console.log(dongcode);

    let url = `/WhereIsMyHome/user.do?action=registregion&dongcode=${dongcode}`;
    fetch(`${url}`)
    	.then(response => {
    		let sidoSel = document.querySelector("#sido");
		    let sido = sidoSel.options[sidoSel.selectedIndex].text;
		
		    let gugunSel = document.querySelector("#gugun");
		    let gugun = gugunSel.options[gugunSel.selectedIndex].text;
		
		    let dongSel = document.querySelector("#dong");
		    let dong = dongSel.options[dongSel.selectedIndex].text;
		    
		    let html = `<button class="col-md-3 regionBtn" onclick="searchInterestRegion('${sido }', '${gugun }', '${dong }');">${dong }</button>`;
		    
		    document.querySelector("#interestRegionDiv").insertAdjacentHTML("beforeend", html);
    	});
})

function searchInterestRegion(sido, gugun, dong) {
	console.log(sido);
	console.log(gugun);
	console.log(dong);
	
	let url = ctx+`/map.do/searchDong/${sido}/${gugun}/${dong}`;
    console.log(url);

    fetch(`${url}`)
        .then(response => response.json())
        .then(data => makeList(data));
}
//document.querySelector("#goSearch").addEventListener("click", function () {
//let url =
//    "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"; // 공공데이터 주소
//let gugunSel = document.querySelector("#gugun");
//let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
//// let yearSel = document.querySelector("#year");
//// let year = yearSel[yearSel.selectedIndex].value;
//const date = new Date();
//
//let year = date.getFullYear();
//// let monthSel = document.querySelector("#month");
//// let month = monthSel[monthSel.selectedIndex].value;
//let month = ('0' + (date.getMonth() + 1)).slice(-2);
//let dealYM = year + month;
//let queryParams =
//    encodeURIComponent("serviceKey") + "=" + "kbxg3ZuJuU8P4su0cwh0HHA4SmrTvbsq815LsWbO6KhYxKQVLMvI3LbhM6hyu8fNW0TmPeW35EPjQa%2F1PpVoFw%3D%3D"; /*Service Key*/
//queryParams +=
//    "&" +
//    encodeURIComponent("LAWD_CD") +
//    "=" +
//    encodeURIComponent(regCode); /*아파트소재 구군*/
//queryParams +=
//    "&" + encodeURIComponent("DEAL_YMD") + "=" + encodeURIComponent(dealYM); /*조회년월*/
//queryParams +=
//    "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /*페이지번호*/
//queryParams +=
//    "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("30"); /*페이지당건수*/
//
//fetch(`${url}?${queryParams}`)
//    .then((response) => response.text())
//    .then((data) => makeList(data));
//});

function makeList(data) {
	
	let apts = data.aptList;

    //지도 관련

    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    var myPos = new kakao.maps.LatLng(36.098594, 128.38977) //lat: 36.098594, lng: 128.38977 }
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: myPos, //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
    };

    let tbody = document.querySelector("#aptlist");
//    let parser = new DOMParser();
//    const xml = parser.parseFromString(data, "application/xml");
    // console.log(xml);

//    let apts = xml.querySelectorAll("item");


    //다시 동 확인
//    let dongSel = document.querySelector("#dong");

    //동을 선택했을경우 동에 맞는 정보만 표시합니다.

//    if (dongSel.selectedIndex > 0) {
//
//        apts = Array.from(apts).filter(ele => {
//            console.log("받아온것" + ele.querySelector("법정동").textContent)
//            console.log("선택한것" + dongSel[dongSel.selectedIndex].textContent)
//            if (ele.querySelector("법정동").textContent.trim() === dongSel[dongSel.selectedIndex].textContent.trim()) {
//                return ele;
//            }
//        })
//    }

    init();
    // if (apts == null) {
    if (apts.length === 0) {
        alert("검색 내역이 없습니다!")
        hideResult()
    } else {
        showResult();

        let map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        let geocoder = new kakao.maps.services.Geocoder();

        console.log(apts)

        //주소로 좌표 얻기

        let addressArr = [];
        let aptArr = [];
        
        
        apts.forEach((apt) => {
            let aptInfo = {};
//            let addressTmp = "";
            //중개사 소재지

//            // 시
//            let si = document.querySelector("#sido");
//            let siText = si[si.selectedIndex].textContent;
//            // 구
//            let gun = document.querySelector("#gugun");
//            let gunText = gun[gun.selectedIndex].textContent;

//            // 법정동
//            let dong = apt.querySelector("법정동").textContent;
//
//            // 지번
//            let jinum = apt.querySelector("지번").textContent;

//            addressTmp = siText + " " + gunText + dong + " " + jinum
            let address = apt["sido"] + " " + apt["gugun"] + " " + apt["dong"] + apt["jibun"];

//            addressArr.push(addressTmp);
            addressArr.push(address);

            //아파트 정보
//            aptInfo.address = addressTmp;
//            aptInfo.aptName = apt.querySelector("아파트").textContent;
//            aptInfo.aptPrice = apt.querySelector("거래금액").textContent;//거래금액
//            aptInfo.aptSize = apt.querySelector("전용면적").textContent;//면적
//            aptInfo.aptYear = apt.querySelector("건축년도").textContent;//날짜
            aptInfo.address = address;
//            aptInfo.aptName = str.includes(apt["아파트이름"]) ? apt["아파트이름"] : apt["아파트이름"]+"아파트" ;
            aptInfo.aptName = apt["apartmentName"];
            // console.log(aptInfo.aptName);
            aptInfo.aptPirce = apt["dealAmount"];
            aptInfo.aptSize = apt["area"];
            aptInfo.aptYear = apt["buildYear"];
            
            aptArr.push(aptInfo);
            let tr = document.createElement("tr");

            let nameTd = document.createElement("td");
            nameTd.appendChild(document.createTextNode(apt["apartmentName"]));
            tr.appendChild(nameTd);

            let floorTd = document.createElement("td");
            floorTd.appendChild(document.createTextNode(apt["buildYear"]));
            tr.appendChild(floorTd);

            let areaTd = document.createElement("td");
            areaTd.appendChild(document.createTextNode(apt["area"]));
            tr.appendChild(areaTd);

            let dongTd = document.createElement("td");
            dongTd.appendChild(document.createTextNode(apt["dong"]));
            tr.appendChild(dongTd);

            let priceTd = document.createElement("td");
            priceTd.appendChild(
                document.createTextNode(apt["dealAmount"] + "만원"),
            );
            priceTd.classList.add("text-end");
            tr.appendChild(priceTd);

            //마커 생성
            geocoder.addressSearch(aptInfo.address, function (result, status) {
                // 정상적으로 검색이 완료됐으면 
                if (status === kakao.maps.services.Status.OK) {
                    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                    //아파트 이름,
                    let overlay = displayMarker(coords, aptInfo, map);

                    //클릭 이벤트
                    tr.addEventListener("click", () => {
                        //클릭시 map에 중심을 바꿔라
                        map.panTo(coords);
                        //클릭시 오버레이 열기
                        overlay.setMap(map);
                    })
                } else {
                    console.log("검색이 안됨")
                    console.log(aptInfo.address);
                }
            });


            tbody.appendChild(tr);

        });

        //주소 만들기



        // myPos = new kakao.maps.LatLng(33.450701, 126.570667)
        // let message = "";
        // displayMarker(myPos, message,map);
        // aptArr.forEach((aptInfo)=>{
        //     geocoder.addressSearch(aptInfo.address, function(result, status) {
        //         // 정상적으로 검색이 완료됐으면 
        //         if (status === kakao.maps.services.Status.OK) {
        //             var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        //             //아파트 이름,
        //             displayMarker(coords, aptInfo.aptName ,map);
        //         }else{
        //             console.log("검색이 안됨")
        //             console.log(aptInfo.address);
        //         }
        //     });
        // });
    }
    document.querySelector("#dealAmount").addEventListener("click", function() {
    	let url = ctx+`/map.do/sortAmount`;
    	fetch(`${url}`)
        .then(response => response.json())
        .then(data => makeList(data));
        	
    });
    document.querySelector("#buildYear").addEventListener("click", function() {
    	let url = ctx+`/map.do/sortYear`;
    	fetch(`${url}`)
    	.then(response => response.json())
    	.then(data => makeList(data));
    	
    });
    document.querySelector("#area").addEventListener("click", function() {
    	let url = ctx+`/map.do/sortArea`;
    	fetch(`${url}`)
    	.then(response => response.json())
    	.then(data => makeList(data));
    	
    });



}

function showResult() {
    document.querySelector("#aptListSection").setAttribute("style", "display: flex;");
}
function hideResult() {
    document.querySelector("#aptListSection").setAttribute("style", "display: none;");
}
function init() {
    let map = document.querySelector("#map");
    map.innerHTML = ``;
    let tbody = document.querySelector("#aptlist");
    let len = tbody.rows.length;
    for (let i = len - 1; i >= 0; i--) {
        tbody.deleteRow(i);
    }
    
}




// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, aptInfo, map) {
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: locPosition,
    });
    marker.setMap(map);

    let mkWrap = document.createElement("div")
    mkWrap.className = "markerWrap"
    let info = document.createElement("div")
    info.className = "info"
    let title = document.createElement("div")
    title.className = "title"
    title.innerHTML = aptInfo.aptName;
    let closeBtn = document.createElement("button")
    closeBtn.className = "close"
    closeBtn.setAttribute("title", "닫기")
    title.appendChild(closeBtn);

    let body = document.createElement("div")
    body.className = "body"
    body.innerHTML = `<div class="desc" >
        <div class="ellipsis" style="width:100%;height:100%; word-break:break-all;margin-bottom:5px "><p ">상세주소 : ${aptInfo.address} ${aptInfo.aptName}</p>
        <p>건축년도 : ${aptInfo.aptYear}</p>
        <p> 아파트 면적 : ${aptInfo.aptSize}</p>
        <p>거래 금액 : ${aptInfo.aptPirce}</p>
        </div>
    </div>`;

    info.appendChild(title);
    info.appendChild(body);
    mkWrap.appendChild(info);

    // 인포윈도우를 생성합니다
    // var infowindow = new kakao.maps.InfoWindow({
    //     content : iwContent
    // });

    // 인포윈도우를 마커위에 표시합니다 
    // infowindow.open(map, marker);

    var overlay = new kakao.maps.CustomOverlay({
        content: mkWrap,
        map: map,
        position: marker.getPosition()
    });

    //오버레이 닫기
    closeBtn.addEventListener("click", () => {
        overlay.setMap(null);
    })

    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);

    //오버레이 열기
    kakao.maps.event.addListener(marker, 'click', function () {
        overlay.setMap(map);
        map.setCenter(locPosition);
    });
    closeBtn.dispatchEvent(new Event("click"));
    return overlay;
}    
// 정렬 하는 친구


