<template>
  <div>
  <Navigation></Navigation>
  <form>
    <div class="form-group">
      <label for="emailAddress">Email</label>
      <input type="email" class="form-control" id="emailAddress" placeholder="Enter Email" v-model="email">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" placeholder="Enter Password" v-model="password">
    </div>
    <button type="submit" class="btn btn-primary" @click.stop.prevent="Login()">Submit</button>
  </form>
  </div>
</template>

<script>
import Navigation from '../components/Nav.vue'
export default {
  name: 'Login',
  components: {
    'Navigation': Navigation
  },
  data: function() {
    return {
      email: '',
      password: '',
    }
  },
  methods: {
    Login: async function() {
      if (this.password == '' || this.email == '') {
        this.msg = "Please fill out all fields"
        return
      }
      let requestInfo = {
        type: 'login',
        data: {
          password: this.password,
          email: this.email
        }
      }
      let vm = this
      await this.$http.post(this.api(), requestInfo).then( function (response) {
        vm.$store.commit('updateField', {user_id: response.data.response})
      }).catch( function (error) {
        console.log(error)
      })
      vm.$router.push({ name: 'Tasks' })
    }
  }
}
</script>