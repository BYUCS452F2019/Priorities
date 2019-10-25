<template>
  <div>
    <div class="card" style="width: 60rem;" v-for="item in tasks" v-bind:key="item.id">
      <div class="card-body">
        <h3 class="card-title">{{ item.name }}</h3>
        <p class="card-text">Priority: {{ item.priority }}</p>
        <p class="card-text">Description: {{item.description }}</p>
      </div>
    </div>
    <button type="button" class="btn btn-primary my-5" @click.stop.prevent="toggleForm()">Add task</button>
    <form v-if="showForm">
      <div class="form-group">
        <label for="taskName">Task Name</label>
        <input type="text" class="form-control" id="taskName" placeholder="Task Name" v-model="email">
      </div>
      <div class="form-group">
        <label for="taskDescription">Task Description</label>
        <input type="text" class="form-control" id="taskDescription" placeholder="Task Description" v-model="password">
      </div>
      <div>
        <select v-model="selected">
          <option v-for="option in priorities" v-bind:value="option" v-bind:key="option">
            {{ option }}
          </option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary my-3">Create task</button>
      <span>{{msg}}</span>
    </form>
  </div>
</template>

<script>
export default {
  name: 'Tasks',
  data: function () {
    return {
      tasks: [
        {
          id: 1,
          name: 'Shopping',
          description: 'Shopping List: ...',
          priority: 'High'
        },
        {
          id: 2,
          name: 'Homework',
          description: 'Assignment: ...',
          priority: 'medium'
        },
        {
          id: 3,
          name: 'Date Night',
          description: 'Schedule: ...',
          priority: 'low'
        }
      ],
      priorities: [
        'low', 'medium', 'high'
      ],
      showForm: false
    }
  },
  methods: {
    toggleForm: function () {
      this.showForm = !this.showForm
    }
  }
}
</script>
