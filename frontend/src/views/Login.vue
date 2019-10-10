<template>
  <form>
    <div class="form-group">
      <label for="emailAddress">Email Address</label>
      <input type="email" class="form-control" id="emailAddress" placeholder="Enter Email" v-model="email">
    </div>
    <div class="form-group">
      <label for="password">Email Address</label>
      <input type="password" class="form-control" id="password" placeholder="Enter Password" v-model="password">
    </div>
    <button type="submit" class="btn btn-primary" @click.stop.prevent="Login()">Submit</button>
    <span>{{msg}}</span>
  </form>
</template>

<script>
export default {
  name: 'Login',
  props: {
    registering: {
      type: Boolean,
      required: true
    }
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
    Login: async function() {
      this.msg = ''
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
      await axios.post(this.api(), requestInfo).then( function (response) {
        this.$store.user_id = response.data.user_id
        vm.router.push({ name: 'Home' })
      }).catch( function (error) {
        console.log(error)
      })
    }
  }
}
</script>