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
      state.priorities.push(priority)
    },
    addToTasks(state, payload) {
      let task = {
        task_id: payload.task_id,
        user_id: payload.taskPayload.data.user_id,
        priority_id: payload.taskPayload.data.priority_id,
        title: payload.taskPayload.data.title,
        description: payload.taskPayload.data.description,
        due_date: payload.taskPayload.data.due_date,
        createdDate: payload.taskPayload.data.createdDate,
        completed: payload.taskPayload.data.completed,
        start_remind_date: payload.taskPayload.data.start_remind_date,
      }
      state.tasks.push(task)
    }
  },
  actions: {

  }
})
