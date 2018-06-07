/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { VsBodyTemperatureDetailComponent } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature-detail.component';
import { VsBodyTemperatureService } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature.service';
import { VsBodyTemperature } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature.model';

describe('Component Tests', () => {

    describe('VsBodyTemperature Management Detail Component', () => {
        let comp: VsBodyTemperatureDetailComponent;
        let fixture: ComponentFixture<VsBodyTemperatureDetailComponent>;
        let service: VsBodyTemperatureService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsBodyTemperatureDetailComponent],
                providers: [
                    VsBodyTemperatureService
                ]
            })
            .overrideTemplate(VsBodyTemperatureDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsBodyTemperatureDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsBodyTemperatureService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new VsBodyTemperature('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.vsBodyTemperature).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
