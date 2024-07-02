from django.contrib import admin
from .models import Plant


class PlantAdmin(admin.ModelAdmin):
    list_display = ('name', 'scientific_name', 'price')  # Customize displayed fields


admin.site.register(Plant, PlantAdmin)
