let loginedUser;

function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
var ctx = getContextPath();
const login = () => {
    let formData = document.getElementById('login-form');
    let url = ctx + `/user.do/login/${encodeURIComponent(formData["emailid"].value)}/${encodeURIComponent(formData["emaildomain"].value)}/${encodeURIComponent(formData["password"].value)}`;
    fetch(url,{method:"POST"})
        .then(response => response.json())
            .then(data => {
                console.log(data);
                if (data.resMsg == "로그인 성공!!!") {
                    alert("로그인 성공!!!");
                    location.href = ctx;
                }
                else if (data.resMsg =="로그인 실패") {
                    alert("로그인 실패");
                    location.href = ctx;
                }
            });
    // document.getElementById('login-form').submit();
}

const hideToggle = () => {
    document.querySelector("#user-info").classList.toggle("hide");
    document.querySelector("#login-li").classList.toggle("hide");
    document.querySelector("#join-li").classList.toggle("hide");
}

const join = () => {
    const user = {
        emailId: getValueFromInput("#join-emailid"),
//        emailDomain: getValueFromInput("#join-emaildomain"),
        password: getValueFromInput("#join-password"),
        username: getValueFromInput("#join-username"),
        address: getValueFromInput("#join-address"),
        phone: getValueFromInput("#join-phone")
    }

    if (!validateInput(user)) {
        alert("빈칸이 없도록 입력해주세요!");
        return;
    }

    let formData = document.getElementById('join-form');
    console.log(user);
    let url = ctx + `/user.do/join/${encodeURIComponent(formData["emailid"].value)}/${encodeURIComponent(formData["emaildomain"].value)}/${encodeURIComponent(formData["password"].value)}/${encodeURIComponent(formData["name"].value)}/${encodeURIComponent(formData["addr"].value)}/${encodeURIComponent(formData["phone"].value)}`;
    fetch(url,{method:"POST"})
        .then(response => response.json())
            .then(data => {
                console.log(data);
                if (data.resMsg == "회원등록완료") {
                    location.href = ctx;
                }
                else if (data.resMsg =="중복회원") {
                    alert("이미 있는 회원입니다!");
                }
            });
    // document.getElementById('join-form').submit();
}

const validateInput = ({emailId, password, username, address, phone}) => {
    if (!emailId || !password || !username || !address || !phone) return false;
    else return true;
}

const update = () => {
	const user = {
        emailId: getValueFromInput("#info-emailid"),
//        emailDomain: getValueFromInput("#join-emaildomain"),
        password: getValueFromInput("#info-password"),
        username: getValueFromInput("#info-username"),
        address: getValueFromInput("#info-address"),
        phone: getValueFromInput("#info-phone")
    }

    if (!validateInput(user)) {
        alert("빈칸이 없도록 입력해주세요!");
        return;
    }
    let formData = document.getElementById('modify-form');
    // fetch(ctx + `/user.do/update/${formData.get('emailid')}/${formData.get('emaildomain')}/${formData.get('password')}/${formData.get('name')}/${formData.get('addr')}/${formData.get('phone')}`)
    // fetch(ctx + `/user.do/update/${formData.emailid.value}/${formData.emaildomain.value}/${formData.password.value}/${formData.name.value}/${formData.addr.value}/${formData.phone.value}`)
    let url = ctx + `/user.do/update/${encodeURIComponent(formData["emailid"].value)}/${encodeURIComponent(formData["emaildomain"].value)}/${encodeURIComponent(formData["password"].value)}/${encodeURIComponent(formData["name"].value)}/${encodeURIComponent(formData["addr"].value)}/${encodeURIComponent(formData["phone"].value)}`;
    console.log(formData);
    console.log(url);
    fetch(url,{method:"POST"})
        .then(response => response.json())
            .then(data => {
                console.log(data);
                if (data.resMsg == "개인정보수정완료") {
                    location.href = ctx;
                }
            });
	// document.getElementById('modify-form').submit();
}

const modalHide = (id) => {
    const modal = document.querySelector(`#${id}`);
    modal.querySelector(".btn-secondary").click();
    clearInputInModal();
}

const clearInputInModal = () => {
    const inputs = document.querySelectorAll(".modal input");
    for (let input of inputs) {
        input.value = "";
    }
}

const isExistsUser = (email) => {
    return localStorage.getItem(email) !== null;
}

const getValueFromInput = (query) => {
    return document.querySelector(query).value;
}

document.querySelector("#modal-login-btn").addEventListener("click", login);
document.querySelector("#modal-join-btn").addEventListener("click", join);

document.querySelector("#logout-btn").addEventListener("click", () => {
    if(confirm("로그아웃 하시겠습니까?")) {
        // location.href = ctx + "/user.do/logout";
        fetch(ctx + `/user.do/logout`)
        .then(response => response.json())
            .then(data => {
                console.log(data);
                if (data.resMsg == "로그아웃완료") {
                    location.href = ctx;
                }
            });
    }
})

const withdrawal = () => {
    if(confirm("정말 탈퇴하시겠습니까?")) {
//        localStorage.removeItem(loginedUser.email);
//        alert("탈퇴 성공!!");
//        hideToggle();
        // location.href = ctx + "/user.do/withdrawal";
        
        fetch(ctx + "/user.do/withdrawal")
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if (data.resMsg == "삭제완료") {
                    location.href = ctx;
                }
            });
    }
}

 document.querySelector("#withdrawal-btn").addEventListener("click", withdrawal);
// document.querySelector("#user-info").addEventListener("click", () => {
//     document.querySelector("#info-email").value = loginedUser.email;
//     document.querySelector("#info-username").value = loginedUser.username;
//     document.querySelector("#info-address").value = loginedUser.address;
//     document.querySelector("#info-phone").value = loginedUser.phone;
// });

 document.querySelector("#modal-update-btn").addEventListener("click", update);