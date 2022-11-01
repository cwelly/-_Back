let loginedUser;

const login = () => {
    document.getElementById('login-form').submit();
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

    console.log(user);

    document.getElementById('join-form').submit();
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

	document.getElementById('modify-form').submit();
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

document.querySelector("#modal-login-btn").addEventListener("click", login, true);
document.querySelector("#modal-join-btn").addEventListener("click", join);

document.querySelector("#logout-btn").addEventListener("click", () => {
    if(confirm("로그아웃 하시겠습니까?")) {
        location.href = "user.do?action=logout";
    }
})

const withdrawal = () => {
    if(confirm("정말 탈퇴하시겠습니까?")) {
//        localStorage.removeItem(loginedUser.email);
//        alert("탈퇴 성공!!");
//        hideToggle();
    	location.href= "user.do?action=withdrawal";
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