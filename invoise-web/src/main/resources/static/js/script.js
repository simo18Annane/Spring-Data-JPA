
fetch('../invoice')//fct js qui permet de faire une req HTTP, on va faire un GET sur l'url /invoice qui est censé nous retourner la liste des films au format JSON
    .then(res => res.json())
    .then(res => {
        var invoiceListNode = document.getElementById('invoice-list');
        invoiceListNode.innerHTML = "";

        var table = document.createElement("table");
        table.setAttribute("border", "1");
        invoiceListNode.appendChild(table);

        res.forEach(invoice => {
            console.log(invoice)
            var tr = document.createElement("tr");
            table.appendChild(tr);

            var td = document.createElement("td");
            var text = document.createTextNode(`${invoice.number}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            text = document.createTextNode(`${invoice.customer.name}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            var button = document.createElement("button");
            button.setAttribute("type", "button");
            button.onclick = function () {
                showDetail(`${invoice.number}`);
            };
            text = document.createTextNode("Details");
            button.appendChild(text);
            td.appendChild(button);
            tr.appendChild(td);


        });

    });


function showDetail(invoiceNumber) {
    fetch(invoiceNumber)
        .then(res => res.json())
        .then(res => {
            var invoiceDetailNode = document.getElementById('invoice-detail');
            invoiceDetailNode.innerHTML = "";

            var p = document.createElement("p");
            var text = document.createTextNode(`Number: ${res.number}`);
            p.appendChild(text);
            invoiceDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Customer name: ${res.customer.name}`);
            p.appendChild(text);
            invoiceDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Order number: ${res.orderNumber}`);
            p.appendChild(text);
            invoiceDetailNode.appendChild(p);

        });
}