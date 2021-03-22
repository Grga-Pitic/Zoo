Vue.component("modal", {
    template: "#modal-template"
});

axios.defaults.headers.common['X-CSRF-TOKEN'] = document.getElementById('_csrf').getAttribute('content');

// start app
var app = new Vue({
    el: "#app",
    data: {
        showModal: false,
        actionData: {
            action: '',
            animalId: 0,
            employeeId: 0,
        },
        selectedTab: '',
        tabs: ['employee', 'animal'],
        animal: [],
        employee: [],
    },
    methods: {
        tabClick: function (event) {
            this.selectedTab = event.target.getAttribute('name');
            updateTabs(this);
        },
        save: function (event) {

            var rowData = getRowData(event.target);

            var appObject = this;

            axios
                .post(
                    'http://localhost:8080/' + this.selectedTab,
                    rowData,
                )
                .then(function (response) {
                    if (response.status !== 200) {
                        alert('Occures an error. Code: ' + response.status);
                    }
                    updateTabs(appObject, appObject.selectedTab);
                });

        },
        remove: function (event) {

            var rowData = getRowData(event.target);
            var instanceId = rowData.id;

            var appObject = this;

            axios
                .delete(
                    'http://localhost:8080/' + this.selectedTab,
                    {
                        data: instanceId
                    },
                )
                .then(function (response) {
                    if (response.status !== 200) {
                        alert('Occures an error. Code: ' + response.status);
                        return;
                    }
                    updateTabs(appObject, appObject.selectedTab);
                });
        },
        openModal: function (event) {
            var rowData = getRowData(event.target);

            updateTabs(this);
            this.actionData.action = event.target.getAttribute('action');
            this.actionData[this.selectedTab+'Id'] = parseInt(rowData.id);
            this.showModal = true;
        },
        doAction: function (event) {
            var actionData = this.actionData;
            axios
                .post(
                    'http://localhost:8080/' + actionData.action,
                    actionData,
                )
                .then(function (response) {
                    if (response.status === 204) {
                        alert('Success!!!');
                    }
                });
        }

    }
});

function updateTabs(app) {
    app.tabs.forEach(function (tabName) {
        axios
            .get('http://localhost:8080/' + tabName)
            .then(function (response) {
                app[tabName] = response.data;
            });
    });

}

function getRowData(element) {
    var data = {};
    var inputElements = element.closest('tr').getElementsByTagName('input');
    for (var input of inputElements) {
        data[input.getAttribute('name')] = input.value;
    }

    var selectElements = element.closest('tr').getElementsByTagName('select');
    for (var select of selectElements) {
        data[select.getAttribute('name')] = select.value;
    }

    return data;
}