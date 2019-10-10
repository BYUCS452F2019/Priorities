<template>
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
</template>

<script>
export default {
  name: 'Register',
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
        type: 'registration',
        data: {
          name: this.name,
          password: this.password,
          email: this.email
        }
      }
      let vm = this
      console.log(vm)
      await this.$http.post(this.api(), requestInfo).then( function (response) {
        // this.$store.user_id = response.data.user_id
        console.log(response)
        vm.$router.push({ name: 'Tasks' })
      }).catch( function (error) {
        console.log(error)
      })
    }
  }
}
</script>