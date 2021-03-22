Vue.component("modal", {
    template: "#modal-template"
});

axios.defaults.headers.common['X-CSRF-TOKEN'] = document.getElementById('_csrf').getAttribute('content');

// start app
var app = new Vue({
    el: "#app",
    data: {
        showModal: false,
        selectedTab: '',
        animal: [],
        employee: [],
    },
    methods: {
        tabClick: function (event) {
            var appObject = this;
            var tabName = event.target.getAttribute('name');
            this.selectedTab = tabName;
            axios
                .get('http://localhost:8080/' + tabName)
                .then(function (response) {
                    appObject[tabName] = response.data;
                });
        },
        save: function (event) {
            var data = {};
            var elements = event.target.closest('tr').getElementsByTagName('input');
            for (var element of elements) {
                data[element.getAttribute('name')] = element.value;
            }

            axios
                .post(
                    'http://localhost:8080/' + this.selectedTab,
                    data,
                )
                .then(function (response) {
                    if (response.status !== 200) {
                        alert('Occures an error. Code: ' + response.status);
                    }
                });

        },
        remove: function (event) {

            var element = event.target.closest('tr').getElementsByClassName('id')[0];
            var instanceId = element.value;

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
                    }
                });
        }
    }
});