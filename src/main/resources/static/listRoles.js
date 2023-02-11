function listRoles(user) {
    let clientList = document.createElement('ul');
    for (let i = 0; i < user.client.length; i++) {
        let clients = document.createElement('li');
        clients.textContent = user.client[i].address[i].nameAddress;
        clientList.appendChild(clients);
    }
    return clientList;
}