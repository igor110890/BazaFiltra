function newClients() {

    fetch('http://localhost:8080/create/', {
        method: 'POST',
        body: JSON.stringify({
            name: window.formNewClients.name.value,
            age: window.formNewClients.age.value,
            email: window.formNewClients.email.value,
            password: window.formNewClients.password.value,

        }),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })

        .then(response => response.json())
        .then(user => {
            $('#tClients tr:last').after('<tr id=' + user.id + '>' +
                '<td>' + user.id + '</td>' +
                '<td>' + window.formNewClients.name.value + '</td>' +
                '<td>' + window.formNewClients.age.value + '</td>' +
                '<td>' + window.formNewClients.email.value + '</td>' +
                '<td>' + window.formNewClients.password.value + '</td>' +

                '<td> <button type="button" onclick="getModalEdit(' + user.id + ')" class="btn btn-primary btn-sm">Edit</button> </td>' +
                '<td> <button type="button" onclick="getModalDelete(' + user.id + ')" class="btn btn-danger btn-sm">Delete</button> </td>' +
                '</tr>');

            window.formNewClients.name.value = "";
            window.formNewClients.age.value = "";
            window.formNewClients.email.value = "";
            window.formNewClients.password.value = "";


            $('#NewUserCreated').modal();
        });
}