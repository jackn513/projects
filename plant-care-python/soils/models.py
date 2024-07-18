from django.db import models

from singlesoil.models import SingleSoil


# Create your models here.


class Soils(models.Model):
    type = models.CharField(max_length=100)
    ph_level = models.FloatField()
    nutrients = models.CharField(max_length=500)
    description = models.CharField(max_length=500)

    def __str__(self):
        return self.type

    class Meta:
        db_table = 'soils'  # Specify the database table name


