const getStudentAllocationButton = document.getElementById(
  "get-student-allocation"
);

getStudentAllocationButton.addEventListener("click", (e) => {
  e.preventDefault();
  const url = "localhost:8080/student/allocation";
  fetch(url, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => console.log(data))
    .catch((err) => console.log(err));
});
