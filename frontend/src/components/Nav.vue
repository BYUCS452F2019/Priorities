<template>
  <div class="mb-5">
    <h2>Priorities</h2>
    <nav>
      <router-link v-for="routes in links"
             v-bind:key="routes.id"
             :to="routes.page">
        {{ routes.text }}
      </router-link>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'Navigation',
  data () {
    return {
      links: [
        {
          id: 0,
          text: 'Home',
          page: '/'
        },
        {
          id: 1,
          text: 'Tasks',
          page: '/tasks'
        },
        {
          id: 2,
          text: 'Priorities',
          page: '/priorities'
        }
      ]
    }
  }
}
</script>
