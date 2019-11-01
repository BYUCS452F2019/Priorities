<template>
  <div>
    <Navigation></Navigation>
    <div class="card" style="width: 60rem;" v-for="item in $store.state.priorities" v-bind:key="item.id">
      <div class="card-body">
        <h3 class="card-title">{{ item.name }}</h3>
        <p class="card-text">Priority: {{ item.title }} - Reminds me: {{item.number}} {{ getType(item.type, item.number) }} in advance</p>
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
            <option v-for="option in timePeriods" v-bind:value="option.value" v-bind:key="option.value">
              {{ option.label }}
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
  data: function () {
    return {
      showForm: false,
      priorityName: '',
      priorityNumber: '',
      selected: '',
      timePeriods: [
        {
          value: 1,
          label: 'Days'
        },
        {
          value: 2,
          label: 'Weeks'
        }
      ]
    }
  },
  components: {
    'Navigation': Navigation
  },
  methods: {
    toggleForm: function () {
      this.showForm = true
    },
    submitPriority () {
      let payload = {
        type: 'addPriority',
        data: {
          user_id: this.$store.state.user_id,
          title: this.priorityName,
          type: this.selected,
          number: this.priorityNumber
        }
      }
      console.log(payload)
      let vm = this
      this.$http.post(this.api(), payload).then(r => {
        console.log(r)
        vm.$store.commit('addToPriorities', {priority_id: r.data.response, priorityPayload: payload})
      }).catch(e => {
        console.log(e)
      })
    },
    getType (type, number) {
      if (type === 1) {
        return number === 1 ? "Day" : "Days" 
      } else {
        return number === 1 ? "Week" : "Weeks"
      }
    }
  },
  created: function () {
    let payload = {
        type: 'getPriorities',
        data: {
          user_id: this.$store.state.user_id
        }
      }
      let vm = this
      this.$http.post(this.api(), payload).then(r => {
        vm.$store.commit('updateField', { priorities: r.data.response })
      }).catch(e => {
        console.log(e)
      })
  },
}
</script>
