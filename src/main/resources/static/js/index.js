const checkbox = document.querySelector("[action='/complete'] label");

checkbox.addEventListener("click", () => {
    checkbox.parentNode.submit();
})