$("#nameColumn").on("click", function(e) {
    $.ajax({
        type: 'post',
        url: "/sorting",
        data: JSON.stringify({ input: "name"}),
        contentType: "application/json; charset=utf-8",
        cache: false,
        success: function (xhr) {
            const list = xhr;
            sortTable(JSON.parse(list))
        }

    })
})
$("#authorColumn").on("click", function(e) {
    $.ajax({
        type: 'post',
        url: "/sorting",
        data: JSON.stringify({ input: "author"}),
        contentType: "application/json; charset=utf-8",
        cache: false,
        success: function (xhr) {
            const list = xhr;
            sortTable(JSON.parse(list))
        }
    })
})
$("#priceColumn").on("click", function(e) {
    $.ajax({
        type: 'post',
        url: "/sorting",
        data: JSON.stringify({ input: "price"}),
        contentType: "application/json; charset=utf-8",
        cache: false,
        success: function (xhr) {
            const list = xhr;
            sortTable(list)
        }
    })
})

function sortTable(list) {
    const page = document.getElementById('page');
    const number = page.innerText.toString();
    if(number === "1") {
        for (let i = 5; i > 0; i--) {   // Удаление старых строк
            document.getElementById("table").deleteRow(i);
        }
        // const table = document.querySelector('tbody')    сделать вставку таблицы на подобие примера ниже
        // table.innerHTML += `
        //     <tr>
        //         <td>${list}
        //                     `;

        const test = document.getElementById("test");   // убрать это из main
        const string = list.toString();
        console.log("data=" + list[0].author);
        test.innerText = list[0].name + "/" + list[0].author + "/" + list[0].price;

    } else {
        window.location.replace("http://localhost:8080/shop?page=1");
    }
}
