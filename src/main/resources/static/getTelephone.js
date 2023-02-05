function getTelephone(id) {

    fetch('http://localhost:8080/getUser/' + id)
        .then(response => response.json())
        .then(user => {

            let adminSelect = "";
            let userSelect = "";

            for (let i = 0; i < user.roles.length; i++) {
                if (user.roles[i].name == "ADMIN") {
                    adminSelect = "selected";
                }
                if (user.roles[i].name == "USER") {
                    userSelect = "selected";
                }
            }

            let modal = document.getElementById('modalWindow');

            modal.innerHTML =
                '<div id="modalEdit"' +
                '     class="modal fade" tabindex="-1" role="dialog"' +
                '     aria-labelledby="TitleModalLabel" aria-hidden="true"' +
                '     data-backdrop="static" data-keyboard="false">' +
                '    <div class="modal-dialog modal-dialog-scrollable">' +
                '        <div class="modal-content">' +
                '            <div class="modal-header">' +
                '                <h5 class="modal-title" id="TitleModalLabel">Edit user</h5>' +
                '                <button type="button" class="close" data-dismiss="modal" aria-label="Close">' +
                '                    <span aria-hidden="true">&times;</span>' +
                '                </button>' +
                '            </div>' +
                            '<table <table class="table table-striped border-top ">' +
                                '<thead>'+
                                '<tr>'+
                                    '<th> </th>' +
                                    '<th>№</th>'+
                                    '<th>Телефон</th>'+
                                    '<th> </th>'+
                                '</tr>'+
                            '</thead>'+
                        '<tbody>'+
                            '<tr>'+
                                '<td >'+
                                '<button class="btn btn-primary" data-dismiss="modal" onclick="editTelephone()">edit</button>' +
                                '</td>'+
                                '<td >'+
                                '<input class="form-control form-control-sm" type="text" name="id" value="' + user.id + '" readonly>' +
                                '</td>'+
                                '<td >'+
                                '<input class="form-control form-control-sm" type="text" name="id" value="' + user.name + '" readonly>' +
                                '</td>'+
                                '<td >'+
                                '<button className="btn btn-danger" data-dismiss="modal" onClick="deleteUser(' + user.id + ')">Delete</button>' +
                                '</td>'+
                            '</tr>'+
                        '</tbody>'+
                            '</table>'    +
                '        </div>' +
                '    </div>' +
                '</div>';

            $("#modalEdit").modal();
        });

}