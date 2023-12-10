const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/user-service-ws'
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/response', (response) => {
        showResponse(JSON.parse(response.body));
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#getAllUsers").prop("disabled", !connected);
    $("#getUser").prop("disabled", !connected);
    $("#deleteUser").prop("disabled", !connected);
    $("#createUser").prop("disabled", !connected);

    if (connected) {
        $("#connectWs").text("Disconnect");
    } else {
        $("#connectWs").text("Connect");
    }
}

function connect() {
    const wsUrl = $("#wsUrl").val();
    if (stompClient.connected) {
        stompClient.deactivate();
        setConnected(false);
    } else {
        stompClient.brokerURL = wsUrl;
        stompClient.activate();
    }
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function getAllUsers() {
    stompClient.publish({
        destination: "/app/users/get-all",
        body: JSON.stringify({})
    });
}

function getUser() {
    const userId = $("#userId").val();
    stompClient.publish({
        destination: "/app/users/get",
        body: JSON.stringify({'id': userId})
    });
}

function deleteUser() {
    const userId = $("#userId").val();
    stompClient.publish({
        destination: "/app/users/delete",
        body: JSON.stringify({'id': userId})
    });
}

function createUser() {
    const firstName = $("#firstName").val();
    const lastName = $("#lastName").val();
    stompClient.publish({
        destination: "/app/users/create",
        body: JSON.stringify({'firstName': firstName, 'lastName': lastName})
    });
}

function showResponse(message) {
    $("#response").text(JSON.stringify(message, null, 4));
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $( "#connectWs" ).click(() => connect());
    $( "#getAllUsers" ).click(() => getAllUsers());
    $( "#getUser" ).click(() => getUser());
    $( "#deleteUser" ).click(() => deleteUser());
    $( "#createUser" ).click(() => createUser());
});