<template>
  <div class="home">
    <h1>Welcome to Priorities</h1>
    <p v-if="loggedIn">Please <a href="/#/login">login</a></p>
    <p v-else>Please <a href="/#/register">Register</a></p>
    <p>{{msg}}</p>
  </div>
</template>

<script>
export default {
  name: 'home',
  data: function () {
    return {
      msg: '',
      loggedIn: false
    }
  },
  created: function () {
    let vm = this
    this.$http.get(this.api()).then(function (response) {
      vm.msg = response.data
    }).catch(function (error) {
      console.log(error)
    })
  }
}
</script>
