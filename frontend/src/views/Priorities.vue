<template>
  <div>
    <Navigation></Navigation>
    <div class="card" style="width: 60rem;" v-for="item in priorities" v-bind:key="item.id">
      <div class="card-body">
        <h3 class="card-title">{{ item.name }}</h3>
        <p class="card-text">Priority: {{ item.number }} {{ item.type }}(s)</p>
      </div>
    </div>
    <button type="button" class="btn btn-primary my-5" @click.stop.prevent="toggleForm()">Add priority</button>
    <form v-if="showForm">
      <div class="form-group">
        <label for="priorityName">Priority Name</label>
        <input v-model="priorityName" type="text" class="form-control" id="priorityName" placeholder="Priority name">
      </div>
      <div>
        <label for="priorityNumber">Due Date</label>
      </div>
      <div class="row">
        <div class="col">
          <input v-model="priorityNumber" type="text" class="form-control" id="priorityNumber" placeholder="1, 2, 3...">
        </div>
        <div class="col">
          <select v-model="selected" style="width: 7rem;">
            <option v-for="option in timePeriods" v-bind:value="option" v-bind:key="option">
              {{ option }}
            </option>
          </select>
        </div>
      </div>
      <button type="submit" class="btn btn-primary my-3" @click.stop.prevent="submitPriority">Create Priority</button>
      <span>{{msg}}</span>
    </form>
  </div>
</template>

<script>
import Navigation from '../components/Nav.vue'
export default {
  name: 'Priorities',
  components: {
    'Navigation': Navigation
  },
  data: function () {
    return {
      priorities: [
        {
          id: 1,
          name: 'High',
          type: 'Day',
          number: '2'
        },
        {
          id: 2,
          name: 'Medium',
          type: 'Week',
          number: '1'
        },
        {
          id: 3,
          name: 'Low',
          type: 'Week',
          number: '2'
        }
      ],
      timePeriods: [
        'Hour(s)',
        'Day(s)',
        'Week(s)',
        'Month(s)',
        'Year(s)'
      ],
      showForm: false,
      selected: '',
      priorityName: '',
      priorityNumber: '',
      msg: ''
    }
  },
  methods: {
    toggleForm: function () {
      this.showForm = true
    },
    submitPriority() {
      let payload = {
        type: "addPriority", 
        data: {
          user_id: this.$store.state.user_id,
          title: this.priorityName,
          type: this.selected,
          number: this.priorityNumber
        }
      }
      console.log(payload)
      this.$http.post(this.api(), payload).then(r => {
        console.log(r)
      }).catch(e => {
        console.log(e)
      })
    }
  }
}
</script>
