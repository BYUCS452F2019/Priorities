import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import json from './config.js'

Vue.prototype.$http = axios

Vue.config.productionTip = false

Vue.mixin({
  methods: {
    getBackendURL: function () {
      return json.backend
    }
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
