$("#nameColumn").on("click", function(e) {
    $.ajax({
        type: 'post',
        url: "/sorting",
        data: JSON.stringify({ input: "name"}),
        contentType: "application/json; charset=utf-8",
        cache: false,
        success: function (xhr) {
            const list = xhr;
            sortTable(list)
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
            sortTable(list)
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
        const thCount = document.querySelectorAll('th');
        console.log(thCount.length);

        for (let i = 5; i > 0; i--) {   // Удаление старых строк
            document.getElementById("table").deleteRow(i);
        }
        const table = document.querySelector('tbody');

        if(thCount.length === 3) {
            for (let i = 0; i < 5; i++) {
                table.innerHTML += `
                <tr>
                    <td>${list[i].name}</td>
                    <td>${list[i].author}</td>
                    <td>${list[i].price}</td>
                </tr>                             `;
            }
        }
        else if(thCount.length === 5) {
            for (let i = 0; i < 5; i++) {
                table.innerHTML += `
                <tr>
                    <td>${list[i].name}</td>
                    <td>${list[i].author}</td>
                    <td>${list[i].price}</td>
                    <form method="post">
                        <td><input class="tocart" type="text" name="name" value="${list[i].name}"></td>
                        <td class=""><input type="submit" value="To cart" class="btn btn-dark"></td>
                    </form>
                </tr>                             `;
            }
        }
        else {
            for (let i = 0; i < 5; i++) {
                table.innerHTML += `
                <tr>
                    <td>${list[i].name}</td>
                    <td>${list[i].author}</td>
                    <td>${list[i].price}</td>
                    <td>
                        <div class="btn-group">
                            <a href="/edit?book_id=${list[i].book_id}" class="btn btn-primary">Сhange</a>
                            <a href="/delete/${list[i].book_id}" class="btn btn-danger">Delete</a>
                        </div>
                    </td>
                    <form method="post">
                        <td><input class="tocart" type="text" name="name" value="${list[i].name}"></td>
                        <td class=""><input type="submit" value="To cart" class="btn btn-dark"></td>
                    </form>
                </tr>                             `;
            }
        }
    } else {
        window.location.replace("http://localhost:8080/shop?page=1");
    }
}
