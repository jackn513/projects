from django.db import models


# Create your models here.

class SingleSoil(models.Model):
    type = models.CharField(max_length=100)
    ph_level = models.FloatField()
    nutrients = models.CharField(max_length=500)
    description = models.CharField(max_length=500)

    def __str__(self):
        return self.name

    class Meta:
        db_table = 'soils_single_soil'  # Specify the database table name
