import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user_id: -1
  },
  mutations: {
    updateField(state, payload) {
      for (var field in payload) {
        Vue.set(state, field, payload[field])
      }
    }
  },
  actions: {

  }
})
