<template>
  <div>
    <Navigation></Navigation>
    <div class="card" style="width: 60rem;" v-for="item in $store.state.tasks" v-bind:key="item.id">
      <div class="card-body">
        <h3 class="card-title">{{ item.title }}</h3>
        <p>Due date: {{ new Date(item.due_date).toLocaleDateString() }}</p>
        <p class="card-text">Priority: {{ getPriorityTitle(item.priority_id) }}</p>
        <p class="card-text">Description: {{item.description }}</p>
      </div>
    </div>
    <button type="button" class="btn btn-primary my-5" @click.stop.prevent="toggleForm()">Add task</button>
    <form v-if="showForm">
      <div class="form-group">
        <label for="taskName">Task Name</label>
        <input
          type="text"
          class="form-control"
          id="taskName"
          placeholder="Task Name"
          v-model="name"
        />
      </div>
      <div class="form-group">
        <label for="taskDescription">Task Description</label>
        <input
          type="text"
          class="form-control"
          id="taskDescription"
          placeholder="Task Description"
          v-model="description"
        />
      </div>
      <div class="form-group">
        <label for="dueDate">Due Date</label>
        <input type="date" class="form-control" id="dueDate" v-model="date" />
      </div>
      <div>
        <select v-model="priority">
          <option
            v-for="option in $store.state.priorities"
            v-bind:value="option"
            v-bind:key="option.priority_id"
          >{{ option.title }}</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary my-3" @click.stop.prevent="submitTask">Create task</button>
    </form>
  </div>
</template>

<script>
import Navigation from '../components/Nav.vue'
export default {
  name: 'Tasks',
  components: {
    'Navigation': Navigation
  },
  data: function () {
    return {
      priority: '',
      name: '',
      description: '',
      date: '',
      showForm: false
    }
  },
  methods: {
    toggleForm: function () {
      this.showForm = true
    },
    computeStartRemindDate (dueDate, priority) {
      dueDate = new Date(dueDate)
      let timeToSub = 0
      if (priority.type === 1) {
        timeToSub = priority.number
      } else {
        timeToSub = priority.number * 7
      }
      let date = new Date(dueDate)
      date.setDate(date.getDate() - timeToSub)
      return date.getTime() + (new Date(this.date).getTimezoneOffset() * 60000)
    },
    submitTask () {
      let payload = {
        type: 'addTask',
        data: {
          user_id: this.$store.state.user_id,
          priority_id: this.priority.priority_id,
          title: this.name,
          description: this.description,
          due_date: new Date(this.date).getTime() + (new Date(this.date).getTimezoneOffset() * 60000),
          creation_date: Date.now() + (new Date(this.date).getTimezoneOffset() * 60000),
          completed: false,
          start_remind_date: this.computeStartRemindDate(this.date, this.priority)
        }
      }
      let vm = this
      console.log(payload)
      this.$http.post(this.api(), payload).then(r => {
        console.log(r)
        if (Date.now() >= payload.data.start_remind_date) {
          vm.$store.commit('addToTasks', {task_id: r.data.response, taskPayload: payload})
          taskAdded()
        }
      }).catch(e => {
        console.log(e)
      })
    },
    getPriorityTitle(priority_id) {
      let priority = this.$store.state.priorities.filter(p => {
        return p.priority_id === priority_id
      })[0]
      if (priority) {
        return priority.title
      } else {
        return ''
      }
    },
    taskAdded() {
      this.priority = ''
      this.name = ''
      this.description = ''
      this.date = ''
      this.showForm = false
    }
  },
  created: function () {
    let payload = {
      type: 'getPriorities',
      data: {
        user_id: this.$store.state.user_id
      }
    }
    this.$http.post(this.api(), payload).then(r => {
      vm.$store.commit('updateField', { priorities: r.data.response })
    }).catch(e => {
      console.log(e)
    })
    payload = {
      type: 'getTasks',
      data: {
        user_id: this.$store.state.user_id
      }
    }
    let vm = this
    this.$http.post(this.api(), payload).then(r => {
      vm.$store.commit('updateField', { tasks: r.data.response })
    }).catch(e => {
      console.log(e)
    })
  }
}
</script>
