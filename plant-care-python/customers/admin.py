from django.contrib import admin
from .models import Customer


class CustomerAdmin(admin.ModelAdmin):
    list_display = ('id', 'customer_name', 'email', 'password', 'created_at', 'updated_at')


admin.site.register(Customer, CustomerAdmin)
