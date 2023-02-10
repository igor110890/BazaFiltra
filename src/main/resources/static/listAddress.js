function listAddress(client) {
    let addressList = document.createElement('ul');
    for (let i = 0; i < client.address.length; i++) {
        let address = document.createElement('li');
        address.textContent = client.address[i].name.substring(5) + " ";
        addressList.appendChild(address);
    }
    return addressList;
}