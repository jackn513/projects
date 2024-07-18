from django.contrib import admin
from .models import SingleSoil, Plant


class SingleSoilAdmin(admin.ModelAdmin):
    list_display = ('type', 'ph_level', 'nutrients', 'description')


admin.site.register(SingleSoil, SingleSoilAdmin)


class PlantAdmin(admin.ModelAdmin):
    list_display = ('name', 'soil')


admin.site.register(Plant, PlantAdmin)
