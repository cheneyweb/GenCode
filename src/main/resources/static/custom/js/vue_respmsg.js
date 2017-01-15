Vue.component('respmsg',{
	props:['respMsg'],
	template : '<div class="alert alert-danger" v-show="respMsg != \'Y\'">'+
		        '<strong>{{respMsg}}</strong>'+
		       '</div>'
})