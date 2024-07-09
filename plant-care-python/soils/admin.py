from django.contrib import admin
from .models import Soils


# Register your models here.


class SoilAdmin(admin.ModelAdmin):
    list_display = ('type', 'nutrients', 'description')


admin.site.register(Soils, SoilAdmin)
