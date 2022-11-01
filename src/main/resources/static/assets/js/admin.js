//공지 추가
let modalAdd =  document.querySelector("#modal-noticeUpload-btn");//추가시 작동
modalAdd.addEventListener("click",()=>{
    //추후에 수정
    alert("등록완료");
    clearInputInModal();
    claerTextareaInModal();
    modalHide("noticeModal");
    
})

//공지 수정
let modalEdit =  document.querySelector(".noticeEditBtn");//추가시 작동
modalEdit.addEventListener("click",()=>{
    //값 가져오기
    document.querySelector("#notice-title").value = document.querySelector("#notice li>a").textContent;
    document.querySelector("#notice-content").value = document.querySelector("#notice .noticeContent p").textContent.trim();
    //추후에 수정
    console.log(document.querySelector("#notice li>a").textContent)
})

//공지 삭제
let modalDel =  document.querySelector(".noticeDelBtn");//추가시 작동
modalDel.addEventListener("click",()=>{
    alert("삭제완료");
    //추후에 수정
})


//모달 종료시 내용 삭제
const modalCloseBtn = [document.querySelector(`#noticeModal .btn-secondary`),document.querySelector(`#noticeModal .btn-close`)];
modalCloseBtn.forEach(btn=>{
    btn.addEventListener("click",ele=>{
        clearInputInModal();
        claerTextareaInModal();
    })
})

//내부 내용 삭제
let claerTextareaInModal = ()=>{
    const inputs = document.querySelectorAll(".modal textarea");
    for (let input of inputs) {
        input.value = "";
    }
}