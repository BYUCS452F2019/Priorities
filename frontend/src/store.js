import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user_id: 0,
    priorities: [],
    tasks: []
  },
  mutations: {
    updateField(state, payload) {
      for (var field in payload) {
        Vue.set(state, field, payload[field])
      }
    },
    addToPriorities(state, payload) {
      let priority = {
        priority_id: payload.priority_id,
        number: payload.priorityPayload.data.number,
        title: payload.priorityPayload.data.title,
        type: payload.priorityPayload.data.type,
        user_id: state.user_id
      }
      console.log(priority)
      console.log(payload)
      state.priorities.push(priority)
    }
  },
  actions: {

  }
})
