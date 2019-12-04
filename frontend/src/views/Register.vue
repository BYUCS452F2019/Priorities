<template>
  <div>
  <Navigation></Navigation>
  <form>
    <div class="form-group">
      <label for="emailAddress">Email Address</label>
      <input type="email" class="form-control" id="emailAddress" placeholder="Enter Email" v-model="email">
    </div>
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" v-model="name">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" placeholder="Enter Password" v-model="password">
    </div>
    <button type="submit" class="btn btn-primary" @click.stop.prevent="Register()">Submit</button>
    <span>{{msg}}</span>
  </form>
  </div>
</template>

<script>
import Navigation from '../components/Nav.vue'
export default {
  name: 'Register',
  components: {
    'Navigation': Navigation
  },
  data: function() {
    return {
      email: '',
      password: '',
      name: '',
      msg: ''
    }
  },
  methods: {
    Register: async function() {
      this.msg = ''
      if (this.name == '' || this.password == '' || this.email == '') {
        this.msg = "Please fill out all fields"
        return
      }
      let requestInfo = {
        type: 'register',
        data: {
          username: this.name,
          password: this.password,
          email: this.email
        }
      }
      let vm = this
      await this.$http.post(this.api(), requestInfo).then(function (response) {

        vm.$store.commit('updateField', {user_id: `${response.data.response}`})
      }).catch(function (error) {
        console.log(error)
      })
      vm.$router.push({ name: 'Tasks' })
    }
  }
}
</script>
