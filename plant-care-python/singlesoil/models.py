from django.db import models


class SingleSoil(models.Model):
    type = models.CharField(max_length=100)
    ph_level = models.FloatField()
    nutrients = models.TextField()
    description = models.TextField()

    def __str__(self):
        return self.type


class Plant(models.Model):
    name = models.CharField(max_length=100)
    soil = models.ForeignKey(SingleSoil, on_delete=models.CASCADE,
                             related_name='plants')  # Make sure the related_name is 'plants'

    def __str__(self):
        return self.name
