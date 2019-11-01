<template>
  <div>
    <Navigation></Navigation>
    <div class="card" style="width: 60rem;" v-for="item in tasks" v-bind:key="item.id">
      <div class="card-body">
        <h3 class="card-title">{{ item.name }}</h3>
        <p>Due date: {{ item.due }}</p>
        <p class="card-text">Priority: {{ item.priority }}</p>
        <p class="card-text">Description: {{item.description }}</p>
      </div>
    </div>
    <button type="button" class="btn btn-primary my-5" @click.stop.prevent="toggleForm()">Add task</button>
    <form v-if="showForm">
      <div class="form-group">
        <label for="taskName">Task Name</label>
        <input type="text" class="form-control" id="taskName" placeholder="Task Name" v-model="name">
      </div>
      <div class="form-group">
        <label for="taskDescription">Task Description</label>
        <input type="text" class="form-control" id="taskDescription" placeholder="Task Description" v-model="description">
      </div>
      <div class="form-group">
        <label for="dueDate">Due Date</label>
        <input type="date" class="form-control" id="dueDate" v-model="date">
      </div>
      <div>
        <select v-model="priority">
          <option v-for="option in $store.state.priorities" v-bind:value="option" v-bind:key="option">
            {{ option.title }}
          </option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary my-3">Create task</button>
      <span>{{msg}}</span>
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
      tasks: [
        {
          id: 1,
          name: 'Shopping',
          description: 'Shopping List: ...',
          priority: 'High',
          due: 'Nov 3, 2019'
        },
        {
          id: 2,
          name: 'Homework',
          description: 'Assignment: ...',
          priority: 'medium',
          due: 'Nov 4, 2019'
        },
        {
          id: 3,
          name: 'Date Night',
          description: 'Schedule: ...',
          priority: 'low',
          due: 'Nov 5, 2019'
        }
      ],
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
    submitTask() {
      let payload = {
        type: "addTask",
        data: {
          user_id: this.$store.state.user_id,
          priority_id: this.priority.priority_id,
          title: this.name,
          description: this.description,
          due_date: this.date,
          createdDate: Date.now(),
          completed: 0,
          start_remind_date: computeStartRemindDate(this.date, this.priority)
        }
      }
      console.log(payload)
      this.$http.post(this.api(), payload).then(r => {
        console.log(r)
      }).catch(e => {
        console.log(e)
      })
    },
    computeStartRemindDate(dueDate, priority) {
      let timeToSub = 0
      if(priority.type == 1) {
        timeToSub = priority.time
      }
      else {
        timeToSub = priority.time * 7
      }
      let date = new Date();
      date.setDate(dueDate - timeToSub);
      return date
    }
  }
}
</script>
