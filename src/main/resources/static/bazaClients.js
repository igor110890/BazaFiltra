bazaClients();

function bazaClients() {
    let tClients = document.getElementById("tClients");
    tClients.innerHTML = "";
    fetch('http://localhost:8080/allClient')
        .then(response => response.json())
        .then(client => {
            client.forEach(function (client) {
                var row = tClients.insertRow();
                row.setAttribute("id", client.id);
                var cell0 = row.insertCell();
                cell0.innerHTML =
                    '<button type="button" onclick="getModalClientsEdit(' + client.id + ')" class="btn btn-primary btn-sm">edit</button>';
                var cell1 = row.insertCell();
                cell1.innerHTML = client.id;
                var cell2 = row.insertCell();
                cell2.innerHTML = client.address;
                var cell3 = row.insertCell();
                cell3.innerHTML =
                    '<button type="button" onclick="getTelephone(' + client.id + ')" class="btn btn-primary btn-sm">телефоны</button>';
                var cell4 = row.insertCell();
                cell4.innerHTML = client.systemClearing;
                var cell5 = row.insertCell();
                cell5.innerHTML = client.dateFilterReplacement;
                var cell6 = row.insertCell();
                cell6.innerHTML =
                    '<button type="button" onclick="getModalClientsEdit(' + client.id + ')" class="btn btn-primary btn-sm">производимые работы</button>';
                var cell7 = row.insertCell();
                cell7.innerHTML = listOfServicesId.id;
                var cell8 = row.insertCell();
                cell8.innerHTML = client.comment;
                var cell9 = row.insertCell();
                cell9.innerHTML =
                    '<button type="button" onclick="getModalClientsDelete(' + client.id + ')" class="btn btn-danger btn-sm">удалить</button>';
            })
        });
}