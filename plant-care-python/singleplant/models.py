from django.db import models


class SinglePlant(models.Model):
    name = models.CharField(max_length=100)
    scientific_name = models.CharField(max_length=200)
    plant_description = models.CharField(max_length=500)
    price = models.DecimalField(max_digits=10, decimal_places=2)
    image_name = models.CharField(max_length=256, blank=True, null=True)
    water = models.CharField(max_length=500)
    light = models.CharField(max_length=999)
    humidity = models.CharField(max_length=999)
    temp = models.CharField(max_length=999)
    toxic = models.CharField(max_length=999)
    fun_fact = models.CharField(max_length=999)
    soil_id = models.IntegerField(null=True)

    def __str__(self):
        return self.name

    class Meta:
        db_table = 'plants_single_plant'  # Specify the database table name

